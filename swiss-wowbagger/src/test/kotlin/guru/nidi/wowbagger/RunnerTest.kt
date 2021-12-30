/*
 * Copyright © 2018 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.wowbagger

import guru.nidi.wowbagger.Wowbagger.action
import guru.nidi.wowbagger.Wowbagger.adjective
import guru.nidi.wowbagger.Wowbagger.interjection
import guru.nidi.wowbagger.Wowbagger.name
import guru.nidi.wowbagger.Wowbagger.subject
import org.junit.jupiter.api.Test

class RunnerTest {
    @Test
    fun simple() {
        System.setProperty("WOWBAGGER_VOICE_FILE_PATH", "../voices/nl2/nl2")
        val int = interjection()
        val gender = Gender.random()
        val names = (0..random(3)).map { name(gender) }
        val number = Number.of(names.size)
        val adj1 = adjective(gender, number)
        val adj2 = adjective(gender, number)
        val subject = subject(gender, number)
        val action = action(number)
        val ns = names.enumerate(Entry("und", "_ u n d")) +
                if (names.size == 1) Entry(", du", "_ 100 d u 200")
                else Entry(", dir", "_ 100 d I r")


        println("$int ${ns.joinToString(" ") { it.entry }} $adj1 $adj2 $subject, $action")
        val phs = mutableListOf(int, Entry.phonemes("_ 100"))
        phs.addAll(ns)
        phs.addAll(listOf(adj1, Entry.phonemes("_ 50"), adj2, subject, Entry.phonemes("_ 500"), action))
//    say(int.phonemes)
        WowbaggerVoice.say(phs.joinToString(" ") { it.phonemes }).playAndWait()
//  say(Subjects.list[246].with(Number.SINGULAR).phonemes).playAndWait()
    }


}
