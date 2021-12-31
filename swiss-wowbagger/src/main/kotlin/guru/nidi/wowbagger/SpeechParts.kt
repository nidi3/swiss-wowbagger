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

fun composeSpeech(names: List<String>): SpeechParts {
    val (effNames, gender) = if (names.isEmpty()) {
        val gender = Gender.random()
        Pair((0..random(3)).map { Wowbagger.name(gender) }.toSet().toList(), gender)
    } else {
        names.map { Wowbagger.name(it) }.let { genderedNames ->
            val nameEntry = genderedNames.map { it.first.with(Number.SINGULAR) }
            val gender =
                if (genderedNames.any { it.first.entry.gender == Gender.M }) Gender.M else Gender.F
            Pair(nameEntry, gender)
        }
    }
    val number = Number.of(effNames.size)
    return SpeechParts(
        Wowbagger.interjection(),
        effNames,
        (1..random(4)).map { Wowbagger.adjective(gender, number) },
        Wowbagger.subject(gender, number),
        Wowbagger.action(number)
    )
}

data class SpeechParts(
    val interjection: Entry<String>,
    val names: List<Entry<String>>,
    val adjectives: List<Entry<String>>,
    val subject: Entry<String>,
    val action: Entry<String>
) {
    fun connect(): List<Entry<String>> {
        val pronoun = if (names.size == 1) Entry(", du", "_ 100 d u 200")
        else Entry(", dir", "_ 100 d I r")
        return listOf(interjection) + Entry.phonemes("_ 100") +
                names.enumerate(Entry("und", "_ u n d")) + pronoun +
                adjectives.interleave(Entry.phonemes("_ 50")) +
                subject + Entry(", ", "_ 500") +
                action
    }
}
