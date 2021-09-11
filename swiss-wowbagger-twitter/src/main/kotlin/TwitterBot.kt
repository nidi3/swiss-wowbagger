import guru.nidi.wowbagger.*
import guru.nidi.wowbagger.Wowbagger.name
import twitter4j.*
import twitter4j.conf.ConfigurationBuilder
import twitter4j.util.function.Consumer
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.random.Random

const val HOUR = 1000 * 60 * 60

fun main() {
    val consumerKey = System.getenv("WOWBAGGER_BOT_CONSUMER_KEY") ?: System.getenv("CONSUMER_KEY")
    val consumerSecret = System.getenv("WOWBAGGER_BOT_CONSUMER_SECRET") ?: System.getenv("CONSUMER_SECRET")
    val accessToken = System.getenv("WOWBAGGER_BOT_ACCESS_TOKEN") ?: System.getenv("ACCESS_TOKEN")
    val accessSecret = System.getenv("WOWBAGGER_BOT_ACCESS_SECRET") ?: System.getenv("ACCESS_SECRET")

    val config = ConfigurationBuilder().run {
        setDebugEnabled(true)
        setOAuthConsumerKey(consumerKey)
        setOAuthConsumerSecret(consumerSecret)
        setOAuthAccessToken(accessToken)
        setOAuthAccessTokenSecret(accessSecret)
        build()
    }
    val twitter = TwitterFactory(config).instance
    val twitterStream = TwitterStreamFactory(config).instance
    twitterStream.onStatus { run {} }
    twitterStream.filter(FilterQuery(twitter.id)).onStatus(TwitterListener(twitter))
    thread {
        while (true) {
//            println(tweet(listOf()))
            twitter.updateStatus(tweet(listOf()))
            sleep((23.5 * HOUR + random(HOUR)).toLong())
//            sleep((HOUR / 2 + random(HOUR / 4)).toLong())
        }
    }
}

fun tweet(names: List<String>): String {
    val seed = Random.nextLong() and 0x000fffffffffffffL
    randomSeed(seed)
    val speech = composeSpeech(names)
    val text = speech.copy(
        names = speech.names.map { it.hashed() },
        subject = speech.subject.hashed()
    ).connect().toText()
    val param = if (names.isEmpty()) "" else "?names=" + names.joinToString(",")
    return "$text https://nidi3.github.io/swiss-wowbagger/#$seed$param"
}

fun Entry<String>.hashed() = Entry("#${entry}", phonemes)

class TwitterListener(val twitter: Twitter) : Consumer<Status> {
    override fun accept(status: Status) {
        if (status.inReplyToStatusId > 0 && status.user.id != twitter.id) {
            val words = status.text.split(Regex("\\W+")).filter { it.length in 3..8 }
            val nearEntries = words.map { name(it) }.filter { it.second <= 1 }
            val nearNames = nearEntries.sortedBy { it.second }.map { it.first.entry.name }.toSet().toList()
            StatusUpdate("@${status.user.screenName} " + tweet(nearNames)).let {
                it.inReplyToStatusId = status.id
                twitter.updateStatus(it)
            }
        }
    }

}
