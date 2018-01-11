package guru.nidi.wowbagger

import guru.nidi.wowbagger.Environment.random
import guru.nidi.wowbagger.Gender.*

object Wowbagger {
    fun adjective(gender: Gender) = Adjectives.list.choose().with(gender)
    fun subject(gender: Gender? = null) = Subjects.list.with(gender).choose()
    fun name(gender: Gender? = null) = Names.list.with(gender).choose()
    fun action() = Actions.list.choose()
    fun interjection() = Interjections.list.choose()

    internal fun String.trimLines() = lines().filter { it.isNotBlank() }

    private fun <T> List<T>.choose() = this[random(this.size)]

    private fun List<Entry<Gendered>>.with(gender: Gender?) = filter { gender == null || gender == it.entry.gender }
}

enum class Gender {
    M, F, N
}

class Entry<out T>(val entry: T, val phonemes: String) {
    override fun toString() = entry.toString()

    companion object {
        fun phonemes(phonemes: String) = of("|" + phonemes) { it }
        fun <T> of(line: String, converter: (String) -> T): Entry<T> {
            val pos = line.indexOf('|')
            return if (pos < 0) Entry(converter(line), "")
            else Entry(converter(line.substring(0, pos).trim()), line.substring(pos + 1))
        }
    }
}

data class Gendered(val name: String, val gender: Gender) {
    constructor(s: String) : this(s.substring(2), Gender.valueOf(s.substring(0, 1).toUpperCase()))

    override fun toString() = name
}

data class Adjective(val name: String)

fun Entry<Adjective>.with(gender: Gender) = if (entry.name.contains("("))
    Entry(replaceParens(entry.name, gender), replaceParens(phonemes, gender))
else
    Entry(entry.name + when (gender) {
        M -> "e"
        N -> "s"
        F -> "i"
    }, phonemes + when (gender) {
        M -> " @"
        N -> " s 200"
        F -> " i"
    })

private fun replaceParens(s: String, gender: Gender) = replaceParens(s, when (gender) {
    M -> 1
    N -> 2
    F -> 3
})

private fun replaceParens(s: String, index: Int) = s.replace(Regex("\\((.*?)/(.*?)/(.*?)\\)"), "$" + index)