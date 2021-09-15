module swiss.wowbagger.voice {
    requires kotlin.stdlib;
    requires kotlin.stdlib.jdk7;
    requires kotlin.stdlib.jdk8;
    requires mbrola.jvm.common;
    requires transitive swiss.wowbagger;

    exports guru.nidi.wowbagger.voice;
    opens guru.nidi.wowbagger.voice;

    opens guru.nidi.wowbagger.voice.nl2;
}
