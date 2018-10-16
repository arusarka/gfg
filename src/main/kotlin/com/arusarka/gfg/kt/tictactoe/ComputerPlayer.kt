package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.extensions.head
import com.arusarka.gfg.kt.tictactoe.CellState.*

class ComputerPlayer : Player{
    override val name: String
        get() = "Computer"

    override val state: CellState = O

    override fun getNextMove(grid: Grid): Coordinate {
        val rowWin = winningCoordinate(state, grid.rows)
        if (rowWin != null) return rowWin

        val colWin = winningCoordinate(state, grid.columns)
        if (colWin != null) return colWin

        val diagWin = winningCoordinate(state, grid.diagonals)
        if (diagWin != null) return diagWin

        val rowWinForOpponent = winningCoordinate(state.opponent(), grid.rows)
        if (rowWinForOpponent != null) return rowWinForOpponent

        val colWinForOpponent = winningCoordinate(state.opponent(), grid.columns)
        if (colWinForOpponent != null) return colWinForOpponent

        val diagWinForOpponent = winningCoordinate(state.opponent(), grid.diagonals)
        if (diagWinForOpponent != null) return diagWinForOpponent

        val possibleForkCoordinates = possibleForkCoordinates(grid, state)
        if (possibleForkCoordinates.isNotEmpty()) return possibleForkCoordinates.head

        val possibleForkCoordinatesForOpponent = possibleForkCoordinates(grid, state.opponent())
        val numberOfPossibleForkCoordinatesForOpponent = possibleForkCoordinatesForOpponent.size

        if (numberOfPossibleForkCoordinatesForOpponent == 1) {
            return possibleForkCoordinatesForOpponent.head
        } else if (numberOfPossibleForkCoordinatesForOpponent > 1) {
            val winningPositionExceptOpponentForks =
                tryWinningPositionWithout(possibleForkCoordinatesForOpponent, grid, state)
            if (winningPositionExceptOpponentForks != null) return winningPositionExceptOpponentForks
        }

        if (grid[1, 1].isEmpty()) return Coordinate(1, 1)

        return grid.emptyCells().random().position
    }

    private fun tryWinningPositionWithout(
        exceptions: List<Coordinate>,
        grid: Grid,
        cellState: CellState
    ): Coordinate? {
        grid.emptyCells()
            .filter { !exceptions.contains(it.position) }
            .forEach { cell ->
                val paths = grid.pathsWithCoordinate(cell.position)
                cell.state = cellState
                val possibleWinningPath = paths.firstOrNull { it.winningPositionFor(cellState) != null }
                cell.resetState()
                if (possibleWinningPath != null) return cell.position
            }
        return null
    }

    private fun winningCoordinate(cellState: CellState, paths: List<Path>): Coordinate? {
        for (path in paths) {
            val winningPositionForCurrentPath = path.winningPositionFor(cellState)
            if (winningPositionForCurrentPath != null) return winningPositionForCurrentPath
        }
        return null
    }

    private fun possibleForkCoordinates(
        grid: Grid,
        cellState: CellState
    ): List<Coordinate> {
        return grid.emptyCells().filter { cell ->
            val paths = grid.pathsWithCoordinate(cell.position)
            cell.state = cellState
            val multipleWinnablePaths = paths.count { it.winningPositionFor(cellState) != null } >= 2
            cell.resetState()
            multipleWinnablePaths
        }.map { cell -> cell.position }
    }
}
