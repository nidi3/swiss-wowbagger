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
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import org.slf4j.LoggerFactory
import twitter4j.*
import twitter4j.User
import twitter4j.conf.ConfigurationBuilder
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.random.Random

class TwitterBotService(
    consumerKey: String,
    private val consumerSecret: String,
    accessToken: String,
    accessSecret: String,
    twitterBaseUrl: String?,
    proxyHost: String?,
    proxyPort: Int?
) {
    private val log = LoggerFactory.getLogger(javaClass)
    private val config = ConfigurationBuilder().run {
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

    private val twitter = TwitterFactory(config).instance

    init {
        runBlocking {
            WebhookHandler(config, twitter.id, "prod").ensureWebhook()
        }
    }

    fun tweetRandomly() {
        val tweet = if (random(100) < 30) {
            twitter.getFollowersList(twitter.id, -1, 200).let {
                if (it.isNotEmpty()) targetTweet(it.random())
                else tweet(listOf())
            }
        } else tweet(listOf())
        twitter.updateStatus(tweet)
    }

    fun handleUpdate(body: TwitterUpdates) {
        if (body.tweet_create_events.isNullOrEmpty()) log.info("Ignoring update, no tweet create events")
        else {
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
        }
    }

    fun encodeToken(crcToken: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        sha256Hmac.init(SecretKeySpec(consumerSecret.toByteArray(), sha256Hmac.algorithm))
        val responseToken = Base64.getEncoder().encodeToString(sha256Hmac.doFinal(crcToken.toByteArray()))
        return "sha256=$responseToken"
    }

    private fun targetTweet(user: User): String {
        val names = user.name.split(" ")
        return "@${user.screenName} ${tweet(names)}"
    }

    private fun tweet(names: List<String>): String {
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

    private fun Entry<String>.hashed() = Entry("#${entry}", phonemes)
}

@Serializable
data class TwitterUpdates(val tweet_create_events: List<TwitterStatus>?)

@Serializable
data class TwitterStatus(
    val id: Long,
    val in_reply_to_status_id: Long?,
    val user: TwitterUser,
    val text: String
)

@Serializable
data class TwitterUser(val id: Long, val screen_name: String)
