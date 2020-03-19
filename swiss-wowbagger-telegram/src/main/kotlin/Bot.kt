import de.sciss.jump3r.Main
import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.Number
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
            val text = update.message.text.toLowerCase()
            println(text)
            val chatId = update.message.chatId

            fun send(text: String) = execute(SendMessage(chatId, text))
            fun sendAudio(text: String, desc: String, wav: File) = File(wav.parentFile, wav.name + ".mp3").use { out ->
                Main().run(arrayOf("-S", "--preset", "standard", "-q", "0", "-m", "s", wav.absolutePath, out.absolutePath))
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
                    command.command == "schrib" -> send(textOf(compose(command.rest)))
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
                            Wowbagger.say(msg.joinToString(" ") { it.phonemes }, speed = 2 - speed / 100.0 * 1.7).use {
                                sendAudio("${msg[0].entry.capitalize()} $names", textOf(msg), it.file)
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
        val res = Regex("/(?<cmd>[^@ ]+)(@${botUsername.toLowerCase()})?(?<rest> .*)?").matchEntire(text)
        return res?.let { Command(res.groups["cmd"]!!.value, res.groups["rest"]?.value?.trim() ?: "") }
    }

    class Command(val command: String, val rest: String)

    private fun textOf(entries: List<Entry<String>>): String {
        return entries.joinToString(" ") { it.entry }
                .replace(Regex("\\s+"), " ")
                .replace(Regex(" ([,.!?])"), "$1")
                .capitalize()
    }

    private fun compose(rest: String): List<Entry<String>> {
        val names = rest.split(Regex("[ +,]+")).filter { !it.isBlank() }.toList()
        val int = Wowbagger.interjection()
        val (effNames, gender) = if (names.isEmpty()) {
            val gender = Gender.random()
            Pair((0..random(3)).map { Wowbagger.name(gender) }, gender)
        } else {
            names.map { Wowbagger.name(it) }.let { genderedNames ->
                val nameEntry = genderedNames.map { it.with(Number.SINGULAR) }
                val gender = if (genderedNames.any { it.entry.gender == Gender.M }) Gender.M else Gender.F
                Pair(nameEntry, gender)
            }
        }
        val number = Number.of(effNames.size)
        val adj1 = Wowbagger.adjective(gender, number)
        val adj2 = Wowbagger.adjective(gender, number)
        val subject = Wowbagger.subject(gender, number)
        val action = Wowbagger.action(number)
        val ns = Wowbagger.enumerate(effNames).let {
            it + if (it.size == 1) Entry(", du", "_ 100 d u 200")
            else Entry(", dir", "_ 100 d I r")
        }
        return listOf(int, Entry.phonemes("_ 100")) + ns +
                listOf(adj1, Entry.phonemes("_ 50"), adj2, subject, Entry.phonemes("_ 500"), action)
    }
}
