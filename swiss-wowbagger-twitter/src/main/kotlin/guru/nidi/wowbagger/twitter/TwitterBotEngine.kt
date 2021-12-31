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
import org.slf4j.LoggerFactory
import org.slf4j.event.Level

object TwitterBotEngine {
    fun create(twitter: TwitterBotService) = embeddedServer(CIO, environment = applicationEngineEnvironment {
        log = LoggerFactory.getLogger(TwitterBotEngine.javaClass)

        connector {
            port = System.getenv("PORT")?.toInt() ?: 8080
        }

        module {
            mod(twitter)
        }
    })

    private fun Application.mod(twitter: TwitterBotService) {
        install(CallLogging) {
            level = Level.INFO
            filter { call -> call.request.path().startsWith("/") }
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        routing {

            head("/ping") { call.respond(HttpStatusCode.OK) }

            post("/random") {
                // Creates a random tweet. Called by Google Cloud Scheduler (Cron Job).
                log.info("creating random tweet")
                twitter.tweetRandomly()
                call.respond(HttpStatusCode.NoContent)
            }

            post("/{user}/webhook") {
                // Callback from Twitter if something happens
                twitter.handleUpdate(call.receive(TwitterUpdates::class))
                call.respond(HttpStatusCode.NoContent)
            }

            get("/{user}/webhook") {
                // Allows Twitter to verify our webhook.
                // https://developer.twitter.com/en/docs/twitter-api/premium/account-activity-api/guides/securing-webhooks
                val crcToken = call.parameters["crc_token"]
                if (crcToken != null) {
                    log.debug("CRC verification requested for $crcToken")
                    call.respond(CrcResponseToken(twitter.encodeToken(crcToken)))
                } else {
                    call.respond(HttpStatusCode.BadRequest, "crc_token is required")
                }
            }
        }
    }
}

@Serializable
data class CrcResponseToken(val response_token: String)
