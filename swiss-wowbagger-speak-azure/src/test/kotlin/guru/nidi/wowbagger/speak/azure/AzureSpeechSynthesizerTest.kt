package guru.nidi.wowbagger.speak.azure

fun main() {
    val azureSpeechSynthesizer = AzureSpeechSynthesizer()

    azureSpeechSynthesizer.sprich("Stäcketööri Gusti, du strube chnütschblaue Chaflicheib, i tue der eini abewäsche!")
    azureSpeechSynthesizer.sprich("Schissdräck am Loufmeter Sile, du strubi dummi Bohnestange, bisch nid ganz bache?")
    azureSpeechSynthesizer.sprich("Hawasch Hene Fridu und Jüre, dir chlyne Schöggeler, hörit uf lauere!")
    azureSpeechSynthesizer.sprich("Mitz id Chuchi Heidle Lise und Nigge, dir gfräsige Bännesöi, heit der de Gluggsi?")
}
