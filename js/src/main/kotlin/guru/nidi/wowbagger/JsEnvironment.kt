package guru.nidi.wowbagger

import kotlin.js.Math

actual object Environment {
    actual fun random(range: Int): Int {
        return (Math.random() * range).toInt()
    }
}