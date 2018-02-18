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

import org.eclipse.jetty.server.*
import org.eclipse.jetty.server.handler.*
import java.io.*
import java.net.ServerSocket
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


fun main(args: Array<String>) {
    val httpPort = 7123
    PrintWriter(OutputStreamWriter(FileOutputStream(File("log.txt")))).use { log ->
        Thread {
            val ss = ServerSocket(7124)
            while (true) {
                try {
                    val s = ss.accept()
                    val r = s.getInputStream().bufferedReader()
                    var line = r.readLine()
                    while (line != null && line.length > 0) {
                        println(line)
                        line = r.readLine()
                    }
                    s.getOutputStream().writer().use {
                        it.write("hello")
                    }
                    s.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }.apply {
            isDaemon = true
            start()
        }
        val server = Server()
        try {
            preloadClasses()

            val http = ServerConnector(server).apply {
                //                host = "localhost"
                port = httpPort
//                idleTimeout = 30000
            }

            server.apply {
                addConnector(http)
                handler = createHandlers(log)
                start()
                Thread.sleep(1000)
                dumpStdErr()
                join()
            }
        } catch (e: Throwable) {
            e.printStackTrace(log)
            server.stop()
        }
    }
}

private fun createHandlers(log: PrintWriter) = HandlerList().apply {
    handlers = arrayOf(
            RootResourceHandler(log),
            ShutdownHandler("666", true, true),
            DefaultHandler())
}

private fun preloadClasses() {
    //preload classes needed for shutdown, they can be unavailable when jar file has changed while server ran
//    UrlEncoded.class. toString ();
//    FutureCallback.class. toString ();
//    Class.forName("org.eclipse.jetty.server.handler.ShutdownHandler$1");
//    Class.forName("org.eclipse.jetty.io.ManagedSelector$CloseEndPoints");
}

private class RootResourceHandler(val log: PrintWriter) : AbstractHandler() {
    override fun handle(target: String, baseRequest: Request, request: HttpServletRequest, response: HttpServletResponse) {
        log.println(target)
        log.flush()
        response.writer.apply {
            println(target)
            flush()
        }
    }
}