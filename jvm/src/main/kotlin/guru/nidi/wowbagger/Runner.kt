package guru.nidi.wowbagger

import guru.nidi.mbrola.*
import guru.nidi.wowbagger.Wowbagger.action
import guru.nidi.wowbagger.Wowbagger.adjective
import guru.nidi.wowbagger.Wowbagger.interjection
import guru.nidi.wowbagger.Wowbagger.name
import guru.nidi.wowbagger.Wowbagger.subject

fun main(args: Array<String>) {
    val int = interjection()
    val name = name()
    val subject = subject(name.entry.gender)
    val adj1 = adjective(subject.entry.gender)
    val adj2 = adjective(subject.entry.gender)
    val action = action()
    println("$int $name, du $adj1 $adj2 $subject, $action")
    val phs = listOf(int, Entry.phonemes("_ 100"), name, Entry.phonemes("_ 100 d u 200"), adj1, Entry.phonemes("_ 50"), adj2, subject, Entry.phonemes("_ 500"), action)
    say(phs.joinToString(" ") { it.phonemes })
//  say(Adjectives.list[123].with(Gender.F).phonemes+ " A r S")
}

fun say(phonemes: String) {
    Mbrola(Phonemes.fromString(phonemes), Voice.fromClasspath("nl2/nl2")).time(.8).run().use {
        it.play(true)
    }
}

