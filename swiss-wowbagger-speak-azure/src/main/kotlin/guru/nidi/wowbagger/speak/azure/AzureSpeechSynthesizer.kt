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
package guru.nidi.wowbagger.speak.azure

import com.github.benmanes.caffeine.cache.AsyncLoadingCache
import com.github.benmanes.caffeine.cache.Caffeine
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.time.Instant

private const val CACHE_KEY_AUTH_TOKEN = "authToken"

/**
 * Not using Azure SDK as it has strange performance behaviour and most of it is native
 * code which is not debuggable.
 */
class AzureSpeechSynthesizer(private val azureKey: String) {

    private val client = HttpClient(CIO)

    private val cache: AsyncLoadingCache<String, String> = Caffeine.newBuilder()
        .expireAfterWrite(Duration.ofMinutes(9)) // make sure token is never used after 10 minutes
        .refreshAfterWrite(Duration.ofMinutes(8)) // start to fetch fresh token in background after 8 minutes
        .initialCapacity(1)
        .buildAsync { _ ->
            runBlocking {
                fetchToken()
            }
        }

    init {
        // Warmup cache asynchronously
        cache[CACHE_KEY_AUTH_TOKEN]
    }

    fun speakToByteArray(text: String, voice: AzureVoice, format: AudioFormat): ByteArray {
        val ssml = createSsml(text, voice)
        val audio = runBlocking<ByteArray> {

            measureTimeAndPrint("Azure: fetch audio") {
                client.post("https://westeurope.tts.speech.microsoft.com/cognitiveservices/v1") {
                    header("Authorization", "Bearer: ${cache[CACHE_KEY_AUTH_TOKEN].get()}")
                    header("X-Microsoft-OutputFormat", format.azureHeader)
                    header("Content-Type", "application/ssml+xml")
                    body = ssml
                }
            }
        }
        return audio
    }

    /**
     * https://docs.microsoft.com/en-us/azure/cognitive-services/speech-service/rest-text-to-speech#authentication
     */
    private suspend fun fetchToken(): String {
        return measureTimeAndPrint("Azure: fetch token") {
            client.post("https://westeurope.api.cognitive.microsoft.com/sts/v1.0/issueToken") {
                header("Ocp-Apim-Subscription-Key", azureKey)
                header("Content-type", "application/x-www-form-urlencoded")
            }
        }
    }

    private fun createSsml(text: String, voice: AzureVoice): String =
        //language=XML
        """
        <speak version="1.0" xmlns="http://www.w3.org/2001/10/synthesis" xml:lang="de-CH">
            <voice name="${voice.azureKey}">
                <lexicon uri="https://raw.githubusercontent.com/notizklotz/swiss-wowbagger/master-fork/swiss-wowbagger-speak-azure/mundart-lexicon.xml"/>
                <prosody rate="-10%">$text</prosody>
            </voice>
        </speak>
        """.trimIndent()

}

private inline fun <T> measureTimeAndPrint(label: String, block: () -> T): T {
    val before = Instant.now()
    val returnValue = block()

    println("$label ${Duration.between(before, Instant.now())}")

    return returnValue
}

enum class AudioFormat(val azureHeader: String) {
    Wav("riff-16khz-16bit-mono-pcm"), Mp3("audio-16khz-64kbitrate-mono-mp3")
}

enum class AzureVoice(val azureKey: String) {
    DeChF("de-CH-LeniNeural"),
    FrChF("fr-CH-ArianeNeural"),
    ItM("it-IT-DiegoNeural")
}