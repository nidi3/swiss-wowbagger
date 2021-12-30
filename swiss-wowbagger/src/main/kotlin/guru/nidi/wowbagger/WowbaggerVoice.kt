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
package guru.nidi.wowbagger

import guru.nidi.mbrola.*
import java.io.File

object WowbaggerVoice {
    private val voiceFile = findVoiceFile()

    private fun findVoiceFile(): File {
        val paths = listOf(
            System.getProperty("WOWBAGGER_VOICE_FILE_PATH"),
            System.getenv("WOWBAGGER_VOICE_FILE_PATH"),
            "/usr/share/mbrola/nl2/nl2",
            "./voices/nl2/nl2"
        )
        return paths.filterNotNull().map { File(it) }.find { it.exists() }
            ?: throw IllegalStateException("Voice /nl2/nl2 not found. Use system property/env variable WOWBAGGER_VOICE_FILE_PATH to set")
    }

    fun say(phonemes: String, format: Format = Format.WAV, speed: Double = .7) =
        Mbrola(Voice.fromFile(voiceFile), format = format, time = speed)
            .run(Phonemes.fromString(phonemes))

    fun say(phonemes: String, format: Format = Format.WAV, speed: Double = .7, consumer: (File) -> Unit) =
        Mbrola(Voice.fromFile(voiceFile), format = format, time = speed)
            .run(Phonemes.fromString(phonemes), consumer)
}
