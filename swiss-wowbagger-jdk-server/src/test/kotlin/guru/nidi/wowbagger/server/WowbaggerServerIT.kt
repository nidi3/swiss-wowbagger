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
package guru.nidi.wowbagger.server

import org.junit.jupiter.api.Disabled
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class WowbaggerServerIT {

    private val httpClient = HttpClient.newHttpClient()

    private fun requestBuilderTemplate() = HttpRequest.newBuilder().timeout(Duration.ofSeconds(2))

    @Test
    fun getText() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/?v=undefined&names="))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofString())
        assertEquals(200, response.statusCode())
        assertEquals("text/plain;charset=utf-8", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotBlank() }
    }

    @Test
    fun getTextWithNames() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/?names=Nidi%20%C3%84du"))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofString())
        assertEquals(200, response.statusCode())
        assertEquals("text/plain;charset=utf-8", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotBlank() }
        assertContains(response.body(), "Ädu")
    }

    @Test
    fun getJson() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/?format=json&v=undefined&names="))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofString())
        assertEquals(200, response.statusCode())
        assertEquals("application/json", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotBlank() }
    }

    @Test
    fun getJsonWithSanitationNeeded() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/?format=json&v=undefined&names=Thessa+"))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofString())
        assertEquals(200, response.statusCode())
        assertEquals("application/json", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotBlank() }
    }

    @Test
    fun getWav() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/1638101736532?format=wav&v=undefined&names="))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofByteArray())
        assertEquals(200, response.statusCode())
        assertEquals("audio/x-wav", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotEmpty() }
    }

    @Test
    fun getWavWithSpeed() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/1638101736532?format=wav&v=99&names="))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofByteArray())
        assertEquals(200, response.statusCode())
        assertEquals("audio/x-wav", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotEmpty() }
    }

    @Test
    @Disabled("Only works if AZURE_KEY env variable is set")
    fun getWavFromAzure() {
        val request = requestBuilderTemplate()
            .uri(URI("http://localhost:7125/1638101736532?format=wav&v=undefined&names=&voice=exilzuerchere"))
            .GET()
            .build()

        val response = httpClient.send(request, BodyHandlers.ofByteArray())
        assertEquals(200, response.statusCode())
        assertEquals("audio/mpeg", response.headers().firstValue("Content-Type").orElseGet { null })
        assertTrue { response.body().isNotEmpty() }
    }

}