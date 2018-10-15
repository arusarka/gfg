package com.arusarka.gfg.kt.tictactoe

import java.util.*

class HumanPlayer(private val console: Console) : Player {
    constructor() : this(Console())

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
        Scanner(System.`in`)
        if (firstTimeMove) {
            console.write("\nEnter coordinate for X in the format x,y (with the comma in between 1,1 is the top left corner and 3,3 is the bottom right corner) : ")
        } else {
            console.write("\nEnter coordinate for X : ")
        }
        val inputs = console.read().split(",").map { it.trim().toInt() }
        firstTimeMove = false
        return Coordinate(inputs.first() - 1, inputs.last() - 1)
    }

    override val state: Cell.CellState = Cell.CellState.X
}
