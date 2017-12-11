package guru.nidi.wowbagger

actual object Environment {
    actual fun random(range: Int) = (Math.random() * range).toInt()
}