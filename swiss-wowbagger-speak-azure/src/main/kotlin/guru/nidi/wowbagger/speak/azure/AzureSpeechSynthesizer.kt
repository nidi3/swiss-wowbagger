package guru.nidi.wowbagger.speak.azure

import com.microsoft.cognitiveservices.speech.SpeechConfig
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer
import com.microsoft.cognitiveservices.speech.audio.AudioConfig
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

class AzureSpeechSynthesizer {

    private val azureKey: String = System.getenv("AZURE_KEY") ?: throw IllegalStateException("AZURE_KEY env required")

    private val lexicon: Map<String, String> = parseLexicon()

    private val speechConfig = SpeechConfig.fromSubscription(azureKey, "switzerlandnorth").apply {
        speechSynthesisLanguage = "de-CH"
    }

    fun sprich(text: String) {
        val synthesizer = SpeechSynthesizer(speechConfig, AudioConfig.fromDefaultSpeakerOutput())

        val ssml = createSsml(text)
        synthesizer.SpeakSsml(ssml)
    }

    /**
     * TODO: Replace using lexicon support
     * https://docs.microsoft.com/en-us/azure/cognitive-services/speech-service/speech-synthesis-markup?tabs=csharp#use-custom-lexicon-to-improve-pronunciation
     */
    private fun createSsml(text: String): String {
        val insultTextPhonemized = text.split(Regex(" ")).joinToString(" ") {
            val word = it.removeSuffix(",")

            if (lexicon.containsKey(word)) {
                "<phoneme alphabet=\"ipa\" ph=\"${lexicon[word]}\">${word}</phoneme>"
            } else {
                word
            }
        }

        return """
                <speak version="1.0" xmlns="http://www.w3.org/2001/10/synthesis"
                          xmlns:mstts="http://www.w3.org/2001/mstts"
                          xml:lang="de-CH">
                    <voice name="de-CH-LeniNeural">
                    <prosody rate="-10%">
                     $insultTextPhonemized
                    </prosody>
                       
                    </voice>
                </speak>
            """.trimIndent()
    }

    private fun parseLexicon(): Map<String, String> {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val document: Document = builder.parse(javaClass.getResourceAsStream("/mundart-lexicon.xml"))

        val lexemeList = document.documentElement.getElementsByTagName("lexeme")

        val lexiconMap = mutableMapOf<String, String>()
        for (i in 0 until lexemeList.length) {
            val lexeme = lexemeList.item(i) as Element
            val grapheme = lexeme.getElementsByTagName("grapheme").item(0).textContent
            val phoneme = lexeme.getElementsByTagName("phoneme").item(0).textContent
            lexiconMap[grapheme] = phoneme
        }
        return lexiconMap
    }

}