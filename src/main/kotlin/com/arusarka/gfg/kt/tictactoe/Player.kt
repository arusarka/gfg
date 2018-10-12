package com.arusarka.gfg.kt.tictactoe

interface Player {
    val state: Cell.CellState
    val name: String
    fun getNextMove(grid: Grid): Coordinate
}
