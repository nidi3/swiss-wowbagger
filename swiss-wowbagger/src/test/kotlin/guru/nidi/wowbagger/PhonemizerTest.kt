package guru.nidi.wowbagger

import org.junit.jupiter.api.Test

class PhonemizerTest {
    @Test
    fun adjectives() {
        Names.list.subList(0,50).forEachIndexed { i, adj ->
            val name = adj.entry.name.replace(Regex("""\(.*?\)"""), "")
            val phonemes = name.toPhonemes()
            val given = adj.phonemes.replace(Regex("""\(.*?\)"""), "").trim()
            if (phonemes != given) {
                println("$name $given --> $phonemes")
                Wowbagger.say(given+" _ 50").use { it.play(true) }
                Wowbagger.say(phonemes).use { it.play(true) }
                println(i)
            }
        }
    }
}