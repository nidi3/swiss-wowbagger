/*
 * Copyright © 2018 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.wowbagger.twitter

import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.Wowbagger.name
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random

fun main() {
    val consumerKey: String = System.getenv("WOWBAGGER_BOT_CONSUMER_KEY") ?: System.getenv("CONSUMER_KEY")
    val consumerSecret: String = System.getenv("WOWBAGGER_BOT_CONSUMER_SECRET") ?: System.getenv("CONSUMER_SECRET")
    val accessToken: String = System.getenv("WOWBAGGER_BOT_ACCESS_TOKEN") ?: System.getenv("ACCESS_TOKEN")
    val accessSecret: String = System.getenv("WOWBAGGER_BOT_ACCESS_SECRET") ?: System.getenv("ACCESS_SECRET")

    /**
     * Override for testing against Wiremock
     */
    val twitterBaseUrl: String? = System.getenv("TWITTER_BASE_URL")

    /**
     * Override for recording with Wiremock
     */
    val proxyHost: String? = System.getenv("TWITTER_PROXY_HOST")
    val proxyPort: Int? = System.getenv("TWITTER_PROXY_PORT")?.toInt()

    val config = ConfigurationBuilder().run {
        setDebugEnabled(true)
        setOAuthConsumerKey(consumerKey)
        setOAuthConsumerSecret(consumerSecret)
        setOAuthAccessToken(accessToken)
        setOAuthAccessTokenSecret(accessSecret)
        twitterBaseUrl?.let { setRestBaseURL(it) }
        proxyHost?.let { setHttpProxyHost(it) }
        proxyPort?.let { setHttpProxyPort(it) }

        build()
    }
    val twitter = TwitterFactory(config).instance

    embeddedServer(CIO, port = System.getenv("PORT")?.toInt() ?: 8080) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        routing {

            head("/ping") { call.respond(HttpStatusCode.OK) }

            post("/random") {
                log.info("creating random tweet")

                // Creates a random tweet. Called by Google Cloud Scheduler (Cron Job).
                twitter.updateStatus(tweet(listOf()))

                call.respond(HttpStatusCode.NoContent)
            }

            post("/webhook") {
                // Callback from Twitter if something happens

                val body = call.receive(TwitterUpdates::class)

                if (body.tweet_create_events?.isNotEmpty() == true) {
                    body.tweet_create_events.forEach { status: TwitterStatus ->
                        val isReply = status.in_reply_to_status_id != null
                        val isWrittenByOtherUser = status.user.id != twitter.id

                        if (isReply && isWrittenByOtherUser) {
                            log.info("creating reply for {}", status)

                            val words = status.text.split(Regex("\\W+")).filter { it.length in 3..8 }
                            val nearEntries = words.map { name(it) }.filter { it.second <= 1 }
                            val nearNames =
                                nearEntries.sortedBy { it.second }.map { it.first.entry.name }.toSet().toList()

                            val tweetAuthorScreenName = status.user.screen_name

                            StatusUpdate("@$tweetAuthorScreenName " + tweet(nearNames)).let {
                                it.inReplyToStatusId = status.id
                                twitter.updateStatus(it)
                            }
                        } else {
                            log.info(
                                "Conditions not met (isReply: $isReply isWrittenByOtherUser: $isWrittenByOtherUser), ignoring creating reply for {}",
                                status
                            )
                        }
                    }
                } else {
                    log.info("Ignoring update, no tweet create events")
                }

                call.respond(HttpStatusCode.NoContent)
            }

            get("/webhook") {
                // Allows Twitter to verify our webhook.
                // https://developer.twitter.com/en/docs/twitter-api/premium/account-activity-api/guides/securing-webhooks

                val crcToken = call.parameters["crc_token"]
                if (crcToken != null) {
                    log.debug("CRC verification requested for $crcToken")

                    val sha256Hmac = Mac.getInstance("HmacSHA256")
                    sha256Hmac.init(SecretKeySpec(consumerSecret.toByteArray(), "HmacSHA256"))
                    val responseToken = Base64.getEncoder().encodeToString(sha256Hmac.doFinal(crcToken.toByteArray()))

                    call.respond(CrcResponseToken("sha256=$responseToken"))
                } else {
                    call.respond(HttpStatusCode.BadRequest, "crc_token is required")
                }
            }
        }
    }.start(wait = true)
}

fun tweet(names: List<String>): String {
    val seed = Random.nextLong() and 0x000fffffffffffffL
    randomSeed(seed)
    val speech = composeSpeech(names)
    val text = speech.copy(
        names = speech.names.map { it.hashed() },
        subject = speech.subject.hashed()
    ).connect().toText()
    val param = if (names.isEmpty()) "" else "?names=" + names.joinToString(",")
    return "$text https://nidi3.github.io/swiss-wowbagger/#$seed$param"
}

fun Entry<String>.hashed() = Entry("#${entry}", phonemes)

@Serializable
data class CrcResponseToken(val response_token: String)

@Serializable
data class TwitterUser(val id: Long, val screen_name: String)

@Serializable
data class TwitterStatus(
    val id: Long,
    val in_reply_to_status_id: Long?,
    val user: TwitterUser,
    val text: String
)

@Serializable
data class TwitterUpdates(val tweet_create_events: List<TwitterStatus>?)