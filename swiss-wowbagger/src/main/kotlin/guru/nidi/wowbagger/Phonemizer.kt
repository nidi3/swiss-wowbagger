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

import kotlin.math.min

fun String.toPhonemes(): String {
    val me = lowercase()
    var pos = 0
    val res = StringBuilder()
    fun match(s: String) = if (me.substring(pos, min(pos + s.length, me.length)) == s) {
        pos += s.length
        true
    } else false

    while (pos < me.length) {
        res.append(' ').append(
            when {
                match("aa") -> "A 200"
                match("a") -> "A"
                match("bb") -> "p 200"
                match("b") -> "b"
                match("ch") -> if (pos == me.length) "x 200" else "x"
                match("ck") -> "k h 50"
                match("c") -> "g"
                match("d") -> "d"
                match("mech") -> "m e x"
                match("ei") -> "e i"
                match("eu") -> "2 i"
                match("ee") -> "e 200"
                match("e") -> "@"
                match("ff") -> "f 200"
                match("f") -> "f"
                match("gross") -> "g r O 200 s"
                match("gg") -> "g 200"
                match("g") -> "g"
                match("h") -> "h"
                match("ie") -> "i @"
                match("i") -> if (pos == me.length) "i" else "I"
                match("j") -> "i"
                match("k") -> "k h 50"
                match("l") -> "l"
                match("mm") -> "m 200"
                match("m") -> "m"
                match("ng") -> "N"
                match("nn") -> "n 200"
                match("n") -> "n"
                match("oh") -> "O 200"
                match("oo") -> "O 200"
                match("o") -> "O"
                match("pp") -> "p 200"
                match("p") -> "p"
                match("que") -> "k 200 w e"
                match("qu") -> "k u"
                match("rr") -> "r 200"
                match("r") -> "r"
                match("sch") -> "S"
                match("ss") -> "s 200"
                match("st") -> "S t"
                match("sp") -> "S p"
                match("s") -> "s"
                match("tt") -> "t 200"
                match("tz") -> "t s"
                match("t") -> if (pos == me.length) "t 200" else "t"
                match("uu") -> "u 200"
                match("u") -> "u"
                match("v") -> "f"
                match("w") -> "w"
                match("x") -> "g s"
                match("yy") -> "i 200"
                match("y") -> "i"
                match("z") -> "t s"
                match("ää") -> "a 200"
                match("äu") -> "2 i"
                match("ä") -> "a"
                match("ö") -> "2"
                match("ü") -> "y"
                match(" ") -> "_ 50"
                else -> {
                    pos++
                    ""
                }
            }
        )
    }
    return res.substring(1)
}
