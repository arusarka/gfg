package com.arusarka.gfg.kt.solutions

import com.arusarka.gfg.kt.extensions.isPalindrome

fun closestPalindromicNumber(number: Int): Int {
    if (number.isPalindrome()) return number

    var currentNumberUp: Int = number + 1
    var currentNumberDown: Int = number - 1

    while (true) {
        if (currentNumberDown.isPalindrome()) return currentNumberDown
        currentNumberDown--

        if (currentNumberUp.isPalindrome()) return currentNumberUp
        currentNumberUp++
    }
}
