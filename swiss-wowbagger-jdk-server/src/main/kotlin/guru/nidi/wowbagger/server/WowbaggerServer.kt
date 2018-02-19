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
@file:JvmName("WowbaggerServer")

package guru.nidi.wowbagger.server

import com.sun.net.httpserver.*
import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.Number
import java.io.PrintWriter
import java.net.*
import java.util.concurrent.Executors


fun main(args: Array<String>) {
    val httpPort = 7125
    val log = PrintWriter(System.out)
    try {
        HttpServer.create(InetSocketAddress(httpPort), 0).apply {
            createContext("/", RootHandler(log))
            executor = Executors.newFixedThreadPool(20)
            start()
        }
    } catch (e: Throwable) {
        e.printStackTrace(log)
    }
}

class RootHandler(private val log: PrintWriter) : HttpHandler {
    override fun handle(exchange: HttpExchange) {
        exchange.responseBody.use {
            try {
                val seed = exchange.requestURI.path?.substring(1)?.toLongOrNull()
                        ?: System.currentTimeMillis()
                val entries = compose(seed)
                val text = entries.joinToString(" ") { it.entry }
                        .replace(Regex("\\s+"), " ")
                        .replace(Regex(" ([,.!?])"), "$1")
                        .capitalize()
                val query = query(exchange.requestURI)
                val res = when (query["format"]) {
                    "json" -> {
                        exchange.responseHeaders.add("Content-Type", "application/json")
                        """{"id":$seed, "text":"$text"}""".toByteArray()
                    }
                    "wav" -> {
                        exchange.responseHeaders.add("Content-Type", "audio/wav")
                        Wowbagger.say(entries.joinToString(" ") { it.phonemes }).use {
                            it.file.readBytes()
                        }
                    }
                    else -> {
                        exchange.responseHeaders.add("Content-Type", "text/plain;charset=utf-8")
                        text.toByteArray()
                    }
                }
                exchange.responseHeaders.add("Access-Control-Allow-Origin", "*")
                exchange.sendResponseHeaders(200, res.size.toLong())
                it.write(res)
                it.flush()
            } catch (e: Exception) {
                e.printStackTrace(log)
                exchange.sendResponseHeaders(500, 0)
            }
        }
    }

    private fun query(uri: URI) = uri.rawQuery?.split("&")
            ?.map {
                val parts = it.split("=")
                Pair(URLDecoder.decode(parts[0], "UTF-8"),
                        if (parts.size == 1) ""
                        else URLDecoder.decode(parts[1], "UTF-8"))
            }
            ?.toMap()
            ?: mapOf()

    private fun compose(seed: Long): List<Entry<String>> {
        randomSeed(seed)
        val int = Wowbagger.interjection()
        val gender = Gender.random()
        val names = (0..random(3)).map { Wowbagger.name(gender) }
        val number = Number.of(names.size)
        val adj1 = Wowbagger.adjective(gender, number)
        val adj2 = Wowbagger.adjective(gender, number)
        val subject = Wowbagger.subject(gender, number)
        val action = Wowbagger.action(number)
        val ns = Wowbagger.enumerate(names).let {
            it + if (it.size == 1) Entry(", du", "_ 100 d u 200")
            else Entry(", dir", "_ 100 d I r")
        }
        return listOf(int, Entry.phonemes("_ 100")) + ns +
                listOf(adj1, Entry.phonemes("_ 50"), adj2, subject, Entry.phonemes("_ 500"), action)
    }
}