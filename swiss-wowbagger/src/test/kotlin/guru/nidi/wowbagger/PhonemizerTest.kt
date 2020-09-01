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
