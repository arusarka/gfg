package com.arusarka.gfg.kt.solutions

fun howManyXs(x: Int, lower: Int, upper: Int): Int {
    if (lower == upper) return 0
    if ((x < 0) || (x > 9)) throw IllegalArgumentException("value of x should be from 0 to 9, provided is $x")

    var numberOfTimes = 0

    for (number in lower + 1 until upper) {
        numberOfTimes += number.toString().toCharArray().count { it == x.toString().first() }
    }

    return numberOfTimes
}
