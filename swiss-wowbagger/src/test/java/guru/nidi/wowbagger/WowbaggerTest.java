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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

class WowbaggerTest {
    @Test
    @DisabledIfEnvironmentVariable(named = "CI", matches = "true")
    void simple() {
        final Entry<String> name = Wowbagger.INSTANCE.action(Number.SINGULAR);
        System.out.println(name.getEntry());
        new Mbrola(Voice.fromClasspath("guru/nidi/wowbagger/voice/nl2/nl2")).time(.8)
                .run(Phonemes.fromString(name.getPhonemes() + " _ 50")).playAndWait();
    }
}
