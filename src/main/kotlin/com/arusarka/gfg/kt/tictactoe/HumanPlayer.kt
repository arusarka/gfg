package com.arusarka.gfg.kt.tictactoe

import java.util.*

class HumanPlayer : Player {
    override val name: String
        get() = "You"

    override fun getNextMove(grid: Grid): Coordinate {
        val scanner = Scanner(System.`in`)

        print("\nEnter coordinate for X in the format x,y (with the comma in between): ")
        val inputs = scanner.nextLine().split(",").map { it.trim().toInt() }

        return Coordinate(inputs.first(), inputs.last())
    }

    override val state: Cell.CellState = Cell.CellState.X
}
