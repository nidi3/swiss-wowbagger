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

    private fun <T> List<T>.choose() = this[random(size)]

    private fun List<Gendered>.with(gender: Gender?) = filter { gender == null || gender == it.gender }
}

enum class Gender {
    M, F, N
}

data class Gendered(val name: String, val gender: Gender) {
    constructor(s: String) : this(s.substring(2), Gender.valueOf(s.substring(0, 1).toUpperCase()))

    override fun toString() = name
}

data class Adjective(private val name: String) {
    fun with(gender: Gender) = if (name.contains("("))
        name.replace(Regex("\\((.*?)/(.*?)/(.*?)\\)"), when (gender) {
            M -> "$1"
            N -> "$2"
            F -> "$3"
        })
    else
        name + when (gender) {
            M -> "e"
            N -> "s"
            F -> "i"
        }
}
