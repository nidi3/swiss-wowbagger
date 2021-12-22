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
package guru.nidi.wowbagger.server

import com.sun.net.httpserver.*
import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.WowbaggerVoice
import guru.nidi.wowbagger.speak.azure.AudioFormat
import guru.nidi.wowbagger.speak.azure.AzureSpeechSynthesizer
import guru.nidi.wowbagger.speak.azure.AzureVoice
import java.io.PrintWriter
import java.net.*
import java.util.concurrent.Executors
import java.util.regex.Pattern
import kotlin.math.max
import kotlin.math.min

fun main() {
    val httpPort = System.getenv("PORT")?.toInt() ?: 7125
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

private val azureSpeechSynthesizer = AzureSpeechSynthesizer(System.getenv("AZURE_KEY").let {
    if (it == null) {
        println("Warning: no AZURE_KEY env variable found")
        ""
    } else {
        it
    }
})

class RootHandler(private val log: PrintWriter) : HttpHandler {
    override fun handle(exchange: HttpExchange) = try {
        val path = exchange.requestURI.path?.trim('/') ?: ""
        val query = Query.parse(exchange.requestURI)
        val response = when {
            path.startsWith("phon/") -> sayPhonemes(path.substring(5), query)
            else -> compose(path, query)
        }
        writeResponse(exchange, response)
    } catch (e: Exception) {
        e.printStackTrace(log)
        exchange.sendResponseHeaders(500, -1)
    }

    private fun sayPhonemes(path: String, query: Query) = Response(
        mapOf("Content-Type" to "audio/x-wav"),
        WowbaggerVoice.say(path, speed = query.speed()).use { it.file.readBytes() })

    private fun compose(path: String, query: Query): Response {
        val seed = (if (path.isEmpty()) null else path.toLongOrNull()) ?: System.currentTimeMillis()
        randomSeed(seed)

        val names = query.names()
            ?.split(Regex("[ +,]+"))
            ?.map { it.trim() }
            ?.filter { it.isNotBlank() }
            ?.toList()
            ?: listOf()

        val entries = composeSpeech(names).connect()
        val voice = query.voice()
            .let {
                if (it.isNullOrBlank()) {
                    null
                } else {
                    it
                }
            }
            ?.let { Voices.valueOf(it) }
            ?: Voices.roboter

        return when (query.format()) {
            "json" -> Response(
                mapOf("Content-Type" to "application/json"),
                """{"id":$seed, "text":"${entries.toText()}"}"""
            )
            "wav" ->
                when (voice) {
                    Voices.roboter -> {
                        Response(
                            mapOf("Content-Type" to "audio/x-wav"),
                            WowbaggerVoice.say(entries.toPhonemes(), speed = query.speed()).use {
                                it.file.readBytes()
                            })
                    }
                    Voices.exilzuerchere,
                    Voices.tessiner,
                    Voices.welschi -> {
                        Response(
                            mapOf("Content-Type" to "audio/mpeg"),
                            azureSpeechSynthesizer.speakToByteArray(
                                entries.toText(),
                                voice.azureVoice!!,
                                AudioFormat.Mp3
                            )
                        )
                    }
                }
            else
            -> Response(
                mapOf("Content-Type" to "text/plain;charset=utf-8"),
                entries.toText()
            )
        }
    }

    private fun writeResponse(exchange: HttpExchange, response: Response) {
        exchange.responseBody.use { out ->
            response.headers.forEach { (key, value) ->
                exchange.responseHeaders.add(key, value)
            }
            exchange.responseHeaders.add("Access-Control-Allow-Origin", "*")
            val range = exchange.requestHeaders["Range"]?.first()
            if (range != null) {
                val matcher = Pattern.compile("bytes=(\\d+)-(\\d+)").matcher(range)
                val (from, to, res) = if (!matcher.matches()) {
                    Triple(0, response.data.size - 1, response.data)
                } else {
                    val from = matcher.group(1).toInt()
                    val to = matcher.group(2).toInt()
                    Triple(from, to, response.data.sliceArray(from..to))
                }
                exchange.responseHeaders.add("Content-Range", "bytes $from-$to/${response.data.size}")
                exchange.sendResponseHeaders(206, res.size.toLong())
                out.write(res)
            } else {
                exchange.sendResponseHeaders(200, response.data.size.toLong())
                out.write(response.data)
            }
            out.flush()
        }
    }
}

data class Response(val headers: Map<String, String>, val data: ByteArray) {
    constructor(headers: Map<String, String>, data: String) : this(headers, data.toByteArray())
}

data class Query(val elems: Map<String, String>) {
    companion object {
        fun parse(uri: URI) = Query(
            uri.rawQuery?.split("&")?.associate {
                val parts = it.split("=")
                Pair(
                    URLDecoder.decode(parts[0], "UTF-8"),
                    if (parts.size == 1) ""
                    else URLDecoder.decode(parts[1], "UTF-8")
                )
            } ?: mapOf()
        )
    }

    fun names() = elems["names"]?.let { it.ifBlank { null } }

    fun speed() = 2 - min(100, max(0, (elems["v"]?.toIntOrNull()) ?: 80)) / 100.0 * 1.7

    fun format() = elems["format"]

    fun voice() = elems["voice"]
}

@Suppress("EnumEntryName")
private enum class Voices(val azureVoice: AzureVoice?) {
    roboter(null), exilzuerchere(AzureVoice.DeChF), welschi(AzureVoice.FrChF), tessiner(AzureVoice.ItM)
}
