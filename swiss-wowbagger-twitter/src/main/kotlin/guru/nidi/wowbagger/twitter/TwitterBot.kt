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

fun main() {
    val twitter = TwitterBotService(
        consumerKey = System.getenv("WOWBAGGER_BOT_CONSUMER_KEY") ?: System.getenv("CONSUMER_KEY"),
        consumerSecret = System.getenv("WOWBAGGER_BOT_CONSUMER_SECRET") ?: System.getenv("CONSUMER_SECRET"),
        accessToken = System.getenv("WOWBAGGER_BOT_ACCESS_TOKEN") ?: System.getenv("ACCESS_TOKEN"),
        accessSecret = System.getenv("WOWBAGGER_BOT_ACCESS_SECRET") ?: System.getenv("ACCESS_SECRET"),
        twitterBaseUrl = System.getenv("TWITTER_BASE_URL"),
        proxyHost = System.getenv("TWITTER_PROXY_HOST"),
        proxyPort = System.getenv("TWITTER_PROXY_PORT")?.toInt()
    )

    TwitterBotEngine.create(twitter).start(wait = true)
}
