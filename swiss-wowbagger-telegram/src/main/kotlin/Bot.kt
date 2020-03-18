import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.Number
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import kotlin.math.max
import kotlin.math.min

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
        System.setProperty("os.name","linux")
        if (update.message?.text != null) {
            val text = update.message.text.toLowerCase()
            println(text)
            val chatId = update.message.chatId

            fun send(text: String) = execute(SendMessage(chatId, text))

            when {
                text.startsWith("/sag") || text.startsWith("/säg") -> {
                    val names = if (text.length <= 5) null else text.substring(5).let { if (it.isBlank()) null else it }
                    val entries = compose(names?.split(Regex("[ +,]+"))?.toList() ?: listOf())
                    val speed = 2 - min(100, max(0, 80)) / 100.0 * 1.7
                    val msg = entries.joinToString(" ") { it.entry }
                            .replace(Regex("\\s+"), " ")
                            .replace(Regex(" ([,.!?])"), "$1")
                            .capitalize()
                    send(msg)
                    SendAudio().apply {
                        setChatId(chatId)
                        setCaption(msg)
                        setAudio(InputFile(Wowbagger.say(entries.joinToString(" ") { it.phonemes }, speed = speed).use {
                            it.file.inputStream()
                        }, "say $names"))
                    }
                }
            }
        }
    }

    private fun compose(names: List<String>): List<Entry<String>> {
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
