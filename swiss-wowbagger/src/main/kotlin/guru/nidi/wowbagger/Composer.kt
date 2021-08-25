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

fun compose(names: List<String>): List<Entry<String>> {
    val int = Wowbagger.interjection()
    val (effNames, gender) = if (names.isEmpty()) {
        val gender = Gender.random()
        Pair((0..random(3)).map { Wowbagger.name(gender) }, gender)
    } else {
        names.map { Wowbagger.name(it) }.let { genderedNames ->
            val nameEntry = genderedNames.map { it.first.with(Number.SINGULAR) }
            val gender =
                if (genderedNames.any { it.first.entry.gender == Gender.M }) Gender.M else Gender.F
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
            listOf(adj1, Entry.phonemes("_ 50"), adj2, subject, Entry(", ", "_ 500"), action)
}

