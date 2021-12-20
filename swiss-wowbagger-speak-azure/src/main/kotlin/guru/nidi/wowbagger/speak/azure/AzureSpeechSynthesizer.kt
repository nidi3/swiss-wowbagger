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

import com.microsoft.cognitiveservices.speech.*
import com.microsoft.cognitiveservices.speech.audio.AudioConfig


class AzureSpeechSynthesizer {

    private val azureKey: String = System.getenv("AZURE_KEY") ?: throw IllegalStateException("AZURE_KEY env required")

    fun speakToByteArray(text: String, voice: AzureVoice, format: SpeechSynthesisOutputFormat): ByteArray = speak(text, voice, format).audioData

    fun speakToDeviceSpeakers(text: String, voice: AzureVoice) {
        speak(text, voice, SpeechSynthesisOutputFormat.Riff16Khz16BitMonoPcm, AudioConfig.fromDefaultSpeakerOutput())
    }

    private fun speak(
        text: String,
        voice: AzureVoice,
        format: SpeechSynthesisOutputFormat,
        audioConfig: AudioConfig? = null
    ): SpeechSynthesisResult {
        val synthesizer = SpeechSynthesizer(SpeechConfig.fromSubscription(azureKey, "switzerlandnorth").apply {
            speechSynthesisLanguage = "de-CH"
            speechSynthesisLanguage = voice.azureKey
            setSpeechSynthesisOutputFormat(format)
        }, audioConfig)

        val ssml = createSsml(text, voice)
        return synthesizer.SpeakSsml(ssml)
    }

    private fun createSsml(text: String, voice: AzureVoice): String =
        //language=XML
        """
        <speak version="1.0" xmlns="http://www.w3.org/2001/10/synthesis" xml:lang="de-CH">
            <voice name="${voice.azureKey}">
                <lexicon uri="https://raw.githubusercontent.com/notizklotz/swiss-wowbagger/cloud-text-to-speech/swiss-wowbagger-speak-azure/mundart-lexicon.xml"/>
                <prosody rate="-10%">$text</prosody>
            </voice>
        </speak>
        """.trimIndent()

}

enum class AzureVoice(val azureKey: String) {
    DeChF("de-CH-LeniNeural"),
    FrChF("fr-CH-ArianeNeural"),
    ItM("it-IT-DiegoNeural")
}