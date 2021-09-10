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

import de.sciss.jump3r.Main
import guru.nidi.wowbagger.Entry
import guru.nidi.wowbagger.composeSpeech
import guru.nidi.wowbagger.toPhonemes
import guru.nidi.wowbagger.toText
import guru.nidi.wowbagger.WowbaggerVoice
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.bots.AbsSender
import java.io.File

class TelegramMessageHandler(private val telegramApiClient: AbsSender, private val botUsername: String) {

    fun onUpdateReceived(update: TelegramUpdate) {

        if (update.message?.text != null) {
            LoggerFactory.getLogger(javaClass).info("Handling message: {}", update.message.text)

            val text = update.message.text.lowercase()
            val chatId = update.message.chat.id.toString()

            fun send(text: String) = telegramApiClient.execute(SendMessage(chatId, text))
            fun sendAudio(text: String, desc: String, wav: File) = File(wav.parentFile, wav.name + ".mp3").use { out ->
                Main().run(
                    arrayOf(
                        "-S",
                        "--preset",
                        "standard",
                        "-q",
                        "0",
                        "-m",
                        "s",
                        wav.absolutePath,
                        out.absolutePath
                    )
                )
                telegramApiClient.execute(SendAudio().apply {
                    setChatId(chatId)
                    caption = desc
                    performer = "The Wowbagger"
                    title = text
                    //not working?
                    // thumb = InputFile(Thread.currentThread().contextClassLoader.getResourceAsStream("icon.jpg"), "Sag")
                    audio = InputFile(out, text)
                })
            }

            parseCommand(text)?.let { command ->
                when {
                    command.command == "help" || command.command.matches(Regex("h[iü][ul]f")) -> send(HELP_TEXT)
                    command.command == "schrib" -> send(compose(command.rest).toText())
                    command.command.matches(Regex("s[eaä]g")) -> {
                        val say = Regex("(?<speed>(schn[eaä](u|ll))|(langsam))?(?<rest>.*)").matchEntire(command.rest)
                        if (say == null) {
                            send("Hä?")
                        } else {
                            val speed = (when (say.groups["speed"]?.value) {
                                null -> 70
                                "langsam" -> 50
                                else -> 85
                            })
                            val names = say.groups["rest"]?.value ?: ""
                            val msg = compose(names)
                            WowbaggerVoice.say(msg.toPhonemes(), speed = 2 - speed / 100.0 * 1.7).use {
                                sendAudio(
                                    "${msg[0].entry.replaceFirstChar { c -> if (c.isLowerCase()) c.titlecase() else c.toString() }} $names",
                                    msg.toText(),
                                    it.file
                                )
                            }
                        }
                    }
                    else -> {
                    }
                }
            }
        }
    }

    private fun <T> File.use(block: (File) -> T): T = try {
        block(this)
    } finally {
        delete()
    }

    private fun parseCommand(text: String): Command? {
        val res = Regex("/(?<cmd>[^@ ]+)(@${botUsername.lowercase()})?(?<rest> .*)?").matchEntire(text)
        return res?.let { Command(res.groups["cmd"]!!.value, res.groups["rest"]?.value?.trim() ?: "") }
    }

    private data class Command(val command: String, val rest: String)

    private fun compose(rest: String): List<Entry<String>> {
        val names = rest.split(Regex("[ +,]+")).filter { it.isNotBlank() }.toList()
        return composeSpeech(names).connect()
    }

}

const val HELP_TEXT = "/schrib näme\n/sag (schnäll | langsam) näme"