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

import com.github.tomakehurst.wiremock.junit5.WireMockTest
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.RepeatedTest
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@WireMockTest(httpPort = 8081)
internal class TwitterBotIT {

    private val httpClient = HttpClient.newHttpClient()

    private fun requestBuilderTemplate() = HttpRequest.newBuilder().timeout(Duration.ofSeconds(2))

    @Test
    fun crcCheck() {
        val request = requestBuilderTemplate().uri(URI("http://localhost:8080/webhook?crc_token=asdfasdf"))
            .header(HttpHeaders.Accept, "application/json")
            .GET()
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        assertEquals(HttpStatusCode.OK.value, response.statusCode())
        val responseData = Json.parseToJsonElement(response.body()).jsonObject

        assertTrue { responseData["response_token"]?.jsonPrimitive?.content?.isNotBlank() == true }
    }

    /**
     * As the resulting Twitter API calls vary randomly this test is repeated to be almost sure all branches are triggered.
     */
    @RepeatedTest(20)
    fun random() {
        val request = requestBuilderTemplate().uri(URI("http://localhost:8080/random"))
            .POST(HttpRequest.BodyPublishers.noBody())
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.discarding())

        assertEquals(HttpStatusCode.NoContent.value, response.statusCode())
    }

    @Test
    fun webhook() {
        @Language("JSON")
        val requestBody = """
            {
              "tweet_create_events": [
                {
                  "id": 42,
                  "text": "dummytext",
                  "in_reply_to_status_id": 4334,
                  "user": {
                    "id": 4242,
                    "screen_name": "Hektor"
                  }
                }
              ]             
            }
        """.trimIndent()

        val request = requestBuilderTemplate().uri(URI("http://localhost:8080/webhook"))
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .header(HttpHeaders.ContentType, "application/json")
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.discarding())

        assertEquals(HttpStatusCode.NoContent.value, response.statusCode())
    }

}