package com.arusarka.gfg.kt.tictactoe

import java.util.*

class HumanPlayer : Player {
    private var firstTimeMove = true

    override val name: String
        get() = "You"

    override fun getNextMove(grid: Grid): Coordinate {
        var coordinate = getCoordinate()

        while (!grid.isValidMove(coordinate)) {
            coordinate = getCoordinate()
        }
        return coordinate
    }

    private fun getCoordinate(): Coordinate {
        val scanner = Scanner(System.`in`)
        if (firstTimeMove) {
            print("\nEnter coordinate for X in the format x,y (with the comma in between 1,1 is the top left corner and 3,3 is the bottom right corner) : ")
        } else {
            print("\nEnter coordinate for X : ")
        }
        val inputs = scanner.nextLine().split(",").map { it.trim().toInt() }
        firstTimeMove = false
        val coordinate = Coordinate(inputs.first() - 1, inputs.last() - 1)
        return coordinate
    }

    override val state: Cell.CellState = Cell.CellState.X
}
