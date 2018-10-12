package com.arusarka.gfg.kt.tictactoe

class TicTacToeBoard(val grid: Grid) {
    override fun toString(): String {
        return grid.toString()
    }

    private var winningMoveMade: Boolean = false

    fun isStillOpen(): Boolean {
        return !winningMoveMade && grid.emptyCells().isNotEmpty()
    }

    fun setCoordinate(cellState: Cell.CellState, coordinate: Coordinate, game: Game) {
        grid.setCellState(coordinate, cellState)

        val pathsWithCoordinate = grid.pathsWithCoordinate(coordinate)

        if (pathsWithCoordinate.any { it.allCellsHaveState(cellState) }) {
            winningMoveMade = true
            game.onWin(cellState)
        }
    }
}
