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
import io.ktor.http.*
import kotlinx.serialization.Serializable
import org.slf4j.LoggerFactory
import twitter4j.*
import twitter4j.HttpRequest
import twitter4j.auth.OAuth2Authorization
import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.Configuration

class WebhookHandler(private val config: Configuration, private val userId: Long, env: String) {
    private val log = LoggerFactory.getLogger(javaClass)
    private val baseUrl = "account_activity/all/$env/"

    private val oauth2 = OAuth2Authorization(config).also {
        try {
            it.oAuth2Token
        } catch (e: TwitterException) {
            log.warn("Problem generating OAuth2 token", e)
        }
    }

    private val oauth1 = OAuthAuthorization(config)

    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = JacksonSerializer {
                disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            }
        }
    }

    suspend fun ensureWebhook() {
        val serviceUrl = System.getenv("SERVICE_URL") ?: GoogleCloud.serviceUrl()
        if (serviceUrl != null) {
            val webhookUrl = "$serviceUrl/$userId/webhook"
            //TODO check if it's valid? and revalidate?
            if (getWebhooks().none { it.url == webhookUrl }) addWebhook(webhookUrl)
            if (getSubscriptions().subscriptions.none { it.user_id == userId.toString() }) addSubscription()
        }
    }

    private suspend fun getWebhooks(): List<Webhook> {
        return bearerRequest(RequestMethod.GET, "webhooks.json")
    }

    private suspend fun addWebhook(url: String): Webhook {
        return oauthRequest(RequestMethod.POST, "webhooks.json", mapOf("url" to url))
    }

    private suspend fun deleteWebhook(id: String) {
        return oauthRequest(RequestMethod.DELETE, "webhooks/$id.json")
    }

    private suspend fun getSubscriptions(): Subscriptions {
        return bearerRequest(RequestMethod.GET, "subscriptions/list.json")
    }

    private suspend fun addSubscription() {
        return oauthRequest(RequestMethod.POST, "subscriptions.json")
    }

    private suspend fun deleteSubscription() {
        return bearerRequest(RequestMethod.DELETE, "subscriptions/$userId.json")
    }

    private suspend inline fun <reified T> bearerRequest(
        reqMethod: RequestMethod,
        path: String,
        parameters: Map<String, String> = mapOf()
    ): T {
        return client.request(config.restBaseURL + baseUrl + path) {
            method = translateMethod(reqMethod)
            parameters.forEach { parameter(it.key, it.value) }
            header("Authorization", oauth2.getAuthorizationHeader(null))
        }
    }

    private suspend inline fun <reified T> oauthRequest(
        reqMethod: RequestMethod,
        path: String,
        parameters: Map<String, String> = mapOf()
    ): T {
        val req = HttpRequest(
            reqMethod, config.restBaseURL + baseUrl + path,
            parameters.map { HttpParameter(it.key, it.value) }.toTypedArray(),
            oauth1, mapOf()
        )
        return client.request(req.url) {
            method = translateMethod(req.method)
            req.parameters.forEach { parameter(it.name, it.value) }
            header("Authorization", oauth1.getAuthorizationHeader(req))
        }
    }

    private fun translateMethod(method: RequestMethod): HttpMethod = when (method) {
        RequestMethod.GET -> HttpMethod.Get
        RequestMethod.POST -> HttpMethod.Post
        RequestMethod.PUT -> HttpMethod.Put
        RequestMethod.DELETE -> HttpMethod.Delete
        else -> throw IllegalArgumentException("Unhandled method $method")
    }
}

@Serializable
data class Webhook(val id: String, val url: String, val valid: Boolean)

@Serializable
data class Subscriptions(val environment: String, val application_id: String, val subscriptions: List<User>)

@Serializable
data class User(val user_id: String)
