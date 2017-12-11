package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.action
import guru.nidi.wowbagger.Wowbagger.adjective
import guru.nidi.wowbagger.Wowbagger.interjection
import guru.nidi.wowbagger.Wowbagger.name
import guru.nidi.wowbagger.Wowbagger.subject

fun main(args: Array<String>) {
   val int = interjection().capitalize()
   val name = name()
   val subject = subject(name.gender)
   val adj1 = adjective(subject.gender)
   val adj2 = adjective(subject.gender)
   val action = action()
   println("$int $name, du $adj1 $adj2 $subject, $action")
}