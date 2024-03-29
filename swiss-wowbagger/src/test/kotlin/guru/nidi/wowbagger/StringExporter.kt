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

/**
 * Exports all strings. Particularly useful for copying and processing them in Azure Speech Studio.
 */
fun main() {
    println("--- Names:")
    Names.list.forEach { println(it) }

    println("\n--- Actions:")
    Actions.list
        .flatMap { setOf(it.with(Number.SINGULAR), it.with(Number.PLURAL)) }
        .map { it.entry }
        .distinct()
        .forEach { println(it) }

    println("\n--- Adjectives:")
    Adjectives.list.flatMap { adjectiveEntry: Entry<Adjective> ->
        Number.values().map { number: Number ->
            Gender.values().map { gender: Gender ->
                adjectiveEntry.with(gender, number)
            }
        }
    }.distinct().forEach { println(it) }

    println("\n--- Interjections:")
    Interjections.list.map { it.entry }.forEach { println(it) }

    println("\n--- Subjects:")
    Subjects.list
        .flatMap { setOf(it.with(Number.SINGULAR), it.with(Number.PLURAL)) }
        .map { it.entry }
        .distinct()
        .forEach { println(it) }
}
