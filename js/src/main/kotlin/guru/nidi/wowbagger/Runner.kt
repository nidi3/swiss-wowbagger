package guru.nidi.wowbagger

import guru.nidi.wowbagger.Number.SINGULAR
import guru.nidi.wowbagger.Wowbagger.action
import guru.nidi.wowbagger.Wowbagger.adjective
import guru.nidi.wowbagger.Wowbagger.interjection
import guru.nidi.wowbagger.Wowbagger.name
import guru.nidi.wowbagger.Wowbagger.subject

fun insult(): String {
    val int = interjection().entry.capitalize()
    val gender = Gender.random()
    val name = name(gender)
    val subject = subject(gender, SINGULAR)
    val adj1 = adjective(gender, SINGULAR)
    val adj2 = adjective(gender, SINGULAR)
    val action = action(SINGULAR)
    return "$int $name, du $adj1 $adj2 $subject, $action"
}