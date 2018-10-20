package com.arusarka.gfg.kt.solutions.towerofhanoi

data class Disk(val value: Int) {
    fun display(): String {
        return " ".repeat(7 - (value - 1))
            .plus("=".repeat((2 * value - 1)))
            .plus(" ".repeat(7 - (value - 1)))
    }
}
