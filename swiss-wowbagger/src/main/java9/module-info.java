module swiss.wowbagger {
    requires kotlin.stdlib;
    requires kotlin.stdlib.jdk7;
    requires kotlin.stdlib.jdk8;
    requires mbrola.jvm.common;

    exports guru.nidi.wowbagger;
    opens guru.nidi.wowbagger;

    opens guru.nidi.wowbagger.nl2;
}
