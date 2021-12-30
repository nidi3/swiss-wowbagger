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

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import org.slf4j.LoggerFactory
import twitter4j.*
import twitter4j.HttpRequest
import twitter4j.auth.OAuth2Authorization
import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.Configuration

fun enhancedTwitter(config: Configuration) = EnhancedTwitter(config, TwitterFactory(config).instance)

class EnhancedTwitter(private val config: Configuration, private val twitter: Twitter) : Twitter by twitter {
    private val log = LoggerFactory.getLogger(javaClass)

    private val oauth2 by lazy {
        OAuth2Authorization(config).also {
            try {
                it.oAuth2Token
            } catch (e: TwitterException) {
                log.warn("Problem generating OAuth2 token", e)
            }
        }
    }
    private val oauth1 = OAuthAuthorization(config)


    private val client = HttpClient(CIO) {
        install(JsonFeature)
    }

    init {
        val y = oauth1.getAuthorizationHeader(
            HttpRequest(
                RequestMethod.POST,
                "https://api.twitter.com/1.1/account_activity/all/prod/webhooks.json",
                arrayOf(HttpParameter("url", "http://wowbagger.schaltstelle.ch:8080/webhook")), oauth1, mapOf()
            )
        )
        runBlocking {
            val service = System.getenv("K_SERVICE")
            if (service != null) {
                val projectId =
                    client.get<String>("http://metadata.google.internal/computeMetadata/v1/project/project-id") {
                        header("Metadata-Flavor", "Google")
                    }
                val region = client.get<String>("http://metadata.google.internal/computeMetadata/v1/instance/region") {
                    header("Metadata-Flavor", "Google")
                }.split("/").last()
                val token =
                    client.get<Token>("http://metadata.google.internal/computeMetadata/v1/instance/service-accounts/default/token") {
                        header("Metadata-Flavor", "Google")
                    }
                println(service + " " + projectId + " " + region + " " + token)
                val url =
                    client.get<String>("https://${region}-run.googleapis.com/apis/serving.knative.dev/v1/namespaces/${projectId}/services/${service}") {
                        header("Authorization", "Bearer ${token.access_token}")
                    }
                println(url)
            }
        }

    }

    suspend fun getWebhooks(env: String): List<Webhook> {
        return client.get(config.restBaseURL + "account_activity/all/$env/webhooks.json") {
            header("Authorization", oauth2.getAuthorizationHeader(null))
        }
    }

    suspend fun addWebhook(env: String, url: String): List<Webhook> {
        val req = HttpRequest(
            RequestMethod.POST,
            config.restBaseURL + "account_activity/all/$env/webhooks.json",
            arrayOf(), oauth1, mapOf("url" to url)
        )
        return client.submitForm(
            url = req.url,
//            req.parameters.forEach { parameter(it.name, it.value) }
            formParameters = Parameters.build {
                append("url", url)
            }) {
            header("authorization", oauth1.getAuthorizationHeader(req))
        }
    }
}

@Serializable
data class Webhook(val id: Int, val url: String, val valid: Boolean)

@Serializable
data class Token(val access_token: String)
