package com.arusarka.gfg.kt.tictactoe

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertFalse

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
@DisplayName("Tic tac toe board")
class TicTacToeBoardTest {

    @Mock
    lateinit var grid: Grid

    @Mock
    lateinit var path: Path

    @Mock
    lateinit var game: Game

    lateinit var ticTacToeBoard: TicTacToeBoard

    @BeforeEach
    internal fun setUp() {
        ticTacToeBoard = TicTacToeBoard(grid)
    }

    @Test
    fun `should be able to set a coordinate in the grid with a cell state`() {
        val coordinate = Coordinate(1, 1)
        ticTacToeBoard.setCoordinate(Cell.CellState.X, coordinate, game)

        verify(grid).setCellState(coordinate, Cell.CellState.X)
    }

    @Test
    fun `should know a winning move after setting a cell's state`() {
        val coordinate = Coordinate(0, 2)
        val row1 = Path(rowOfCells(0, Cell.CellState.X, Cell.CellState.X, Cell.CellState.X))
        val row2 = Path(rowOfCells(0, Cell.CellState.EMPTY, Cell.CellState.O, Cell.CellState.O))
        Mockito.`when`(grid.pathsWithCoordinate(coordinate)).thenReturn(listOf(row1, row2))

        ticTacToeBoard.setCoordinate(Cell.CellState.X, coordinate, game)

        Mockito.verify(grid).pathsWithCoordinate(coordinate)
        Mockito.verify(game).onWin()
        assertFalse(ticTacToeBoard.isStillOpen())
    }
}
