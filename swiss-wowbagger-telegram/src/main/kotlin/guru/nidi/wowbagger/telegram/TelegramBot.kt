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
package guru.nidi.wowbagger.telegram

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

private val botToken: String = System.getenv("WOWBAGGER_BOT_TOKEN") ?: System.getenv("TOKEN")
private val botUsername: String = System.getenv("WOWBAGGER_BOT_USER") ?: System.getenv("USER")
private val telegramBaseUrl: String? = System.getenv("TELEGRAM_BASE_URL")
private val webookUpdateHandler = TelegramMessageHandler(TelegramApiClient(botToken, telegramBaseUrl), botUsername)

fun main() {
    embeddedServer(CIO, port = System.getenv("PORT")?.toInt() ?: 8080) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

        routing {
            head("/ping") { call.respond(HttpStatusCode.OK) }

            post("/$botToken/webhook") {
                val update = call.receive<TelegramUpdate>()
                try {
                    webookUpdateHandler.onUpdateReceived(update)
                    call.respond(HttpStatusCode.NoContent)
                } catch (e: Exception) {
                    log.error("Could not handle message ${update.message}", e)
                    call.respond(HttpStatusCode.InternalServerError)
                }
            }
        }
    }.start(wait = true)
}

@Serializable
data class TelegramUpdate(val message: TelegramUpdateMessage?)

@Serializable
data class TelegramUpdateMessage(val text: String?, val chat: TelegramUpdateChat)

@Serializable
data class TelegramUpdateChat(val id: Long)
