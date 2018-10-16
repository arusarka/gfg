package com.arusarka.gfg.kt.tictactoe

interface Player {
    val state: CellState
    val name: String
    fun getNextMove(grid: Grid): Coordinate
}
