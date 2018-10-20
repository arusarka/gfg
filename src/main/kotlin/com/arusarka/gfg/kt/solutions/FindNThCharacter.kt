package com.arusarka.gfg.kt.solutions


fun String.rest(): String {
    return this.drop(1)
}

fun findNthCharacter(initial: String, numOfIterations: Int, n: Int): Char {
    return performIterations(initial, numOfIterations)[n]
}

tailrec fun performIterations(string: String, n: Int): String {
    if (n == 0) return string
    return performIterations(convertString(string), n - 1)
}

fun convertString(string: String): String {
    if (string == "") return ""
    return convertChar(string.first()) + convertString(string.rest())
}

fun convertChar(char: Char): String {
    return when (char) {
        '0' -> "01"
        '1' -> "10"
        else -> throw UnsupportedOperationException("")
    }
}


fun main(args: Array<String>) {
    val nthCharacter = findNthCharacter("101", 2, 3)

    println(nthCharacter)
}
