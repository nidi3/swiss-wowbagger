import de.sciss.jump3r.Main
import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.voice.WowbaggerVoice
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import java.io.File

fun main() {
    ApiContextInitializer.init()
    TelegramBotsApi().apply {
        registerBot(Bot())
    }
}

class Bot : TelegramLongPollingBot() {
    override fun getBotToken() = System.getenv("WOWBAGGER_BOT_TOKEN") ?: System.getenv("TOKEN")
    override fun getBotUsername() = System.getenv("WOWBAGGER_BOT_USER") ?: System.getenv("USER")

    override fun onUpdateReceived(update: Update) {
        if (update.message?.text != null) {
            val text = update.message.text.lowercase()
            println(text)
            val chatId = update.message.chatId

            fun send(text: String) = execute(SendMessage(chatId, text))
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
                execute(SendAudio().apply {
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
                    command.command == "help" || command.command.matches(Regex("h[iü][ul]f")) -> send("/schrib näme\n/sag (schnäll | langsam) näme")
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

    class Command(val command: String, val rest: String)

    private fun compose(rest: String): List<Entry<String>> {
        val names = rest.split(Regex("[ +,]+")).filter { it.isNotBlank() }.toList()
        return composeSpeech(names).connect()
    }
}
