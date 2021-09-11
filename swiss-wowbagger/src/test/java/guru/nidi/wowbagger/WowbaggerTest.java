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
package guru.nidi.wowbagger;

import guru.nidi.mbrola.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class WowbaggerTest {
    @Test
    @Disabled
    void simple() {
        final Entry<String> name = Wowbagger.INSTANCE.action(Number.SINGULAR);
        System.out.println(name.getEntry());
        try (final Waveform wave = new Mbrola(Phonemes.fromString(name.getPhonemes() + " _ 50"), Voice.fromClasspath("guru/nidi/wowbagger/nl2/nl2"), Format.WAV).time(.8).run()) {
            wave.play(true);
        }
    }
}
