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
package guru.nidi.wowbagger.speak.azure

fun main() {
    val azureSpeechSynthesizer = AzureSpeechSynthesizer()

    azureSpeechSynthesizer.speakToDeviceSpeakers("Stäcketööri Gusti, du strube chnütschblaue Chaflicheib, i tue der eini abewäsche!", AzureVoice.DeChF)
    azureSpeechSynthesizer.speakToDeviceSpeakers("Schissdräck am Loufmeter Sile, du strubi dummi Bohnestange, bisch nid ganz bache?", AzureVoice.FrChF)
    azureSpeechSynthesizer.speakToDeviceSpeakers("Hawasch Hene Fridu und Jüre, dir chlyne Schöggeler, hörit uf lauere!", AzureVoice.ItM)
    azureSpeechSynthesizer.speakToDeviceSpeakers("Mitz id Chuchi Heidle Lise und Nigge, dir gfräsige Bännesöi, heit der de Gluggsi?", AzureVoice.DeChF)
}
