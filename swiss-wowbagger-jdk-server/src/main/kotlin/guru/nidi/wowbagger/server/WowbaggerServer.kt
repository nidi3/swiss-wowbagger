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
import java.io.PrintWriter
import java.net.*
import java.util.concurrent.Executors
import java.util.regex.Pattern
import kotlin.math.max
import kotlin.math.min

fun main() {
    val httpPort = 7125
    val log = PrintWriter(System.out, true)
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
    override fun handle(exchange: HttpExchange) = exchange.responseBody.use { response ->
        try {
            val query = query(exchange.requestURI)
            val seed = exchange.requestURI.path?.trim('/')?.let {
                if (it.isEmpty()) null else it.toLongOrNull()
            } ?: System.currentTimeMillis()
            val names = query["names"]?.let { it.ifBlank { null } }
            val entries = compose(seed, names?.split(Regex("[ +,]+"))?.toList() ?: listOf())
            val speed = 2 - min(100, max(0, (query["v"]?.toIntOrNull()) ?: 80)) / 100.0 * 1.7

            val data = when (query["format"]) {
                "json" -> {
                    exchange.responseHeaders.add("Content-Type", "application/json")
                    """{"id":$seed, "text":"${entries.toText()}"}""".toByteArray()
                }
                "wav" -> {
                    exchange.responseHeaders.add("Content-Type", "audio/x-wav")
                    Wowbagger.say(entries.toPhonemes(), speed = speed).use {
                        it.file.readBytes()
                    }
                }
                else -> {
                    exchange.responseHeaders.add("Content-Type", "text/plain;charset=utf-8")
                    entries.toText().toByteArray()
                }
            }

            exchange.responseHeaders.add("Access-Control-Allow-Origin", "*")
            val range = exchange.requestHeaders["Range"]?.first()
            if (range != null) {
                val matcher = Pattern.compile("bytes=(\\d+)-(\\d+)").matcher(range)
                val (from, to, res) = if (!matcher.matches()) {
                    Triple(0, data.size - 1, data)
                } else {
                    val from = matcher.group(1).toInt()
                    val to = matcher.group(2).toInt()
                    Triple(from, to, data.sliceArray(from..to))
                }
                exchange.responseHeaders.add("Content-Range", "bytes $from-$to/${data.size}")
                exchange.sendResponseHeaders(206, res.size.toLong())
                response.write(res)
            } else {
                exchange.sendResponseHeaders(200, data.size.toLong())
                response.write(data)
            }
            response.flush()
        } catch (e: Exception) {
            e.printStackTrace(log)
            exchange.sendResponseHeaders(500, 0)
        }
    }

    private fun query(uri: URI) = uri.rawQuery?.split("&")?.associate {
        val parts = it.split("=")
        Pair(
            URLDecoder.decode(parts[0], "UTF-8"),
            if (parts.size == 1) ""
            else URLDecoder.decode(parts[1], "UTF-8")
        )
    } ?: mapOf()

    private fun compose(seed: Long, names: List<String>): List<Entry<String>> {
        randomSeed(seed)
        return composeSpeech(names).connect()
    }
}
