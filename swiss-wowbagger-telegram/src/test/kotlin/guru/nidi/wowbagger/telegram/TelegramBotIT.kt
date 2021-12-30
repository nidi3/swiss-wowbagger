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

import com.github.tomakehurst.wiremock.junit5.WireMockTest
import io.ktor.http.*
import org.intellij.lang.annotations.Language
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers.ofString
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertEquals

@WireMockTest(httpPort = 8081)
internal class TelegramBotIT {

    private val botToken: String = System.getenv("WOWBAGGER_BOT_TOKEN") ?: System.getenv("TOKEN") ?: "dummytoken"

    private val httpClient = HttpClient.newHttpClient()

    private fun requestBuilderTemplate() = HttpRequest.newBuilder().timeout(Duration.ofSeconds(2))
        .uri(URI("http://localhost:8080/$botToken/webhook"))
        .header(HttpHeaders.ContentType, "application/json")

    @Test
    fun commandHelp() {

        @Language("JSON")
        val requestBody = """
            {
              "updateId": 42,
              "message": {
                "text": "/help",
                "chat": {
                  "id": 4242
                }
              }
            }
            """.trimIndent()

        val request = requestBuilderTemplate().POST(ofString(requestBody)).build()
        val response = httpClient.send(request, BodyHandlers.discarding())

        assertEquals(HttpStatusCode.NoContent.value, response.statusCode())
    }

    @Test
    fun commandSchrib() {

        @Language("JSON")
        val requestBody = """
            {
              "updateId": 42,
              "message": {
                "text": "/schrib Ädu",
                "chat": {
                  "id": 4242
                }
              }
            }
            """.trimIndent()

        val request = requestBuilderTemplate().POST(ofString(requestBody)).build()
        val response = httpClient.send(request, BodyHandlers.discarding())

        assertEquals(HttpStatusCode.NoContent.value, response.statusCode())
    }

    @Test
    fun commandSag() {

        @Language("JSON")
        val requestBody = """
            {
              "updateId": 42,
              "message": {
                "text": "/sag Ädu",
                "chat": {
                  "id": 4242
                }
              }
            }
            """.trimIndent()

        val request = requestBuilderTemplate().POST(ofString(requestBody)).build()
        val response = httpClient.send(request, BodyHandlers.discarding())

        assertEquals(HttpStatusCode.NoContent.value, response.statusCode())
    }

}
