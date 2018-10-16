package com.arusarka.gfg.kt.tictactoe

import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertFalse

@ExtendWith(MockKExtension::class)
@DisplayName("Tic tac toe board")
class TicTacToeBoardTest {

    @RelaxedMockK
    lateinit var grid: Grid

    @MockK
    lateinit var path: Path

    @RelaxedMockK
    lateinit var game: Game

    lateinit var ticTacToeBoard: TicTacToeBoard

    @BeforeEach
    internal fun setUp() {
        ticTacToeBoard = TicTacToeBoard(grid)
    }

    @Test
    fun `should be able to set a coordinate in the grid with a cell state`() {
        val coordinate = Coordinate(1, 1)
        ticTacToeBoard.setCoordinate(CellState.X, coordinate, game)

        verify { grid.setCellState(coordinate, CellState.X) }
    }

    @Test
    fun `should know a winning move after setting a cell's state`() {
        val coordinate = Coordinate(0, 2)
        val row1 = Path(rowOfCells(0, CellState.X, CellState.X, CellState.X))
        val row2 = Path(rowOfCells(0, CellState.EMPTY, CellState.O, CellState.O))
        every { grid.pathsWithCoordinate(coordinate) } returns listOf(row1, row2)

        ticTacToeBoard.setCoordinate(CellState.X, coordinate, game)

        verify { grid.pathsWithCoordinate(coordinate) }
        verify { game.onWin() }
        assertFalse(ticTacToeBoard.isStillOpen())
    }
}
