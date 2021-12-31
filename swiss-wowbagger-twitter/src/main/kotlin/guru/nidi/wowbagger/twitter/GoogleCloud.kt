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
package guru.nidi.wowbagger.twitter

import com.fasterxml.jackson.databind.DeserializationFeature
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

object GoogleCloud {
    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = JacksonSerializer {
                disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            }
        }
    }

    private val token by lazy {
        runBlocking {
            metadata<Token>("instance/service-accounts/default/token").access_token
        }
    }

    suspend fun serviceUrl(): String? {
        val service = System.getenv("K_SERVICE") ?: return null
        val region = metadata<String>("instance/region").split("/").last()
        val projectId = metadata<String>("project/project-id")
        val serviceInfo = serviceInfo(region, projectId, service)
        return serviceInfo.status.url
    }

    private suspend inline fun <reified T> metadata(path: String) =
        client.get<T>("http://metadata.google.internal/computeMetadata/v1/$path") {
            header("Metadata-Flavor", "Google")
        }

    private suspend inline fun serviceInfo(region: String, projectId: String, service: String) =
        client.get<ServiceInfo>("https://${region}-run.googleapis.com/apis/serving.knative.dev/v1/namespaces/${projectId}/services/${service}") {
            header("Authorization", "Bearer $token")
        }
}

@Serializable
private data class Token(val access_token: String)

@Serializable
private data class ServiceInfo(val status: ServiceStatus)

@Serializable
private data class ServiceStatus(val url: String)
