package com.arusarka.gfg.kt.tictactoe

import java.util.*

class Console {
    fun read(): String {
        return Scanner(System.`in`).nextLine()
    }

    fun write(msg: String): Unit {
        print(msg)
    }
}
