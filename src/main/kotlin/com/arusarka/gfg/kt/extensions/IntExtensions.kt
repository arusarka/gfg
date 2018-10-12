package com.arusarka.gfg.kt.extensions

fun Int.isPalindrome(): Boolean {
    if (this < 0) return false
    return this.toString().equals(this.toString().reversed())
}
