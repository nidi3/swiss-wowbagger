package guru.nidi.wowbagger

import guru.nidi.wowbagger.Gender.*
import guru.nidi.wowbagger.Wowbagger.action
import guru.nidi.wowbagger.Wowbagger.adjective
import guru.nidi.wowbagger.Wowbagger.interjection
import guru.nidi.wowbagger.Wowbagger.name
import guru.nidi.wowbagger.Wowbagger.subject
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8

object Wowbagger {
    private val adjectives = load("/adjectives.txt").map { Adjective(it) }
    private val subjects = load("/subjects.txt").map { Subject(it) }
    private val names = load("/names.txt").map { Subject(it) }
    private val actions = load("/actions.txt")
    private val interjections = load("/interjections.txt")

    fun adjective(gender: Gender) = adjectives.choose().with(gender)
    fun subject(gender: Gender? = null) = subjects.with(gender).choose()
    fun name(gender: Gender? = null) = names.with(gender).choose()
    fun action() = actions.choose()
    fun interjection() = interjections.choose()

    private fun load(resource: String) = load(javaClass.getResourceAsStream(resource))

    private fun load(stream: InputStream) = InputStreamReader(stream, UTF_8).use { it.readLines() }

    private fun <T> List<T>.choose() = this[(Math.random() * size).toInt()]

    private fun List<Subject>.with(gender: Gender?) = filter { gender == null || gender == it.gender }
}

enum class Gender {
    M, F, N
}

data class Subject(val name: String, val gender: Gender) {
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

fun main(args: Array<String>) {
    val int = interjection().capitalize()
    val name = name()
    val subject = subject(name.gender)
    val adj1 = adjective(subject.gender)
    val adj2 = adjective(subject.gender)
    val action = action()
    println("$int $name, du $adj1 $adj2 $subject, $action")
}
