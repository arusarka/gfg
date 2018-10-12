package com.arusarka.gfg.kt.tictactoe

data class Coordinate(val x: Int, val y: Int) {
    constructor(pair: Pair<Int, Int>) : this(pair.first, pair.second)

    override fun toString(): String {
        return "${x+1},${y+1}"
    }

}
