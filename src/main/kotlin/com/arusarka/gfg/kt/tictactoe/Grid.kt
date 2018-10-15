package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.extensions.tranpose
import com.arusarka.gfg.kt.extensions.get

class Grid(cells: List<List<Cell>>) {
    val rows: List<Path> = cells.map { Path(it) }

    val columns: List<Path> = cells.tranpose().map { Path(it) }

    val diagonals: List<Path> =
        listOf(
            Path(listOf(cells[0, 0], cells[1, 1], cells[2, 2])),
            Path(listOf(cells[0, 2], cells[1, 1], cells[2, 0]))
        )

    fun pathsWithCoordinate(coordinate: Coordinate): List<Path> {
        return rows
            .plus(columns)
            .plus(diagonals)
            .filter { it.containsCellWithCoordinate(coordinate) }
    }

    fun emptyCells(): List<Cell> {
        return rows.flatten().filter { it.isEmpty() }
    }

    operator fun get(row: Int, column: Int): Cell {
        return rows[row, column]
    }

    override fun toString(): String {
        return rows.joinToString("\n_|_|_\n") { row -> row.joinToString("|") }
    }

    fun setCellState(coordinate: Coordinate, cellState: Cell.CellState) {
        val cell = rows[coordinate.x, coordinate.y]
        cell.state = cellState
    }

    fun isValidMove(coordinate: Coordinate): Boolean {
        return coordinate.x <= 2 &&
                coordinate.x >= 0 &&
                coordinate.y <= 2 &&
                coordinate.y >= 0 &&
                rows[coordinate.x, coordinate.y].isEmpty()
    }
}
