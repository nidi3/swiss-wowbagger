package guru.nidi.wowbagger;

import guru.nidi.mbrola.*;
import org.junit.jupiter.api.Test;

class WowbaggerTest {
    @Test
    void simple() {
        final Entry<String> name = Wowbagger.INSTANCE.action(Number.SINGULAR);
        System.out.println(name.getEntry());
        try (final Waveform wave = new Mbrola(Phonemes.fromString(name.getPhonemes() + " _ 50"), Voice.fromClasspath("nl2/nl2"), Format.RAW).time(.8).run()) {
            wave.play(true);
        }
    }
}
