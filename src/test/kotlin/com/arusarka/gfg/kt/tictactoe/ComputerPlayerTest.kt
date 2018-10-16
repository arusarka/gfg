package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.tictactoe.CellState.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ComputerPlayerTest {
    lateinit var computerPlayer: ComputerPlayer

    @Before
    fun setUp() {
        computerPlayer = ComputerPlayer()
    }

    @Test
    fun `should return the remaining slot to complete a row`() {
        val grid = Grid(
            listOf(
                rowOfCells(0, firstCellState = X),
                rowOfCells(1, secondCellState = O, thirdCellState = O),
                rowOfCells(2)
            )
        )

        val nextOptimalMove = computerPlayer.getNextMove(grid)

        assertEquals(Coordinate(1, 0), nextOptimalMove)
    }

    @Test
    fun `should block opponent's winning move`() {
        val grid = Grid(
            listOf(
                rowOfCells(0, firstCellState = O),
                rowOfCells(1, secondCellState = X, thirdCellState = X),
                rowOfCells(2)
            )
        )

        val nextOptimalMove = computerPlayer.getNextMove(grid)

        assertEquals(Coordinate(1, 0), nextOptimalMove)
    }

    @Test
    fun `should create a fork if possible`() {
        val grid = Grid(
            listOf(
                rowOfCells(0, O, X, O),
                rowOfCells(1, thirdCellState = X),
                rowOfCells(2)
            )
        )

        val nextOptimalMove = computerPlayer.getNextMove(grid)

        assertEquals(Coordinate(1, 1), nextOptimalMove)
    }

    @Test
    fun `should block opponents fork`() {
        val grid = Grid(
            listOf(
                rowOfCells(0, firstCellState = X),
                rowOfCells(1, secondCellState = O),
                rowOfCells(2, secondCellState = X)
            )
        )

        val nextOptimalMove = computerPlayer.getNextMove(grid)

        assertEquals(Coordinate(2, 0), nextOptimalMove)
    }

    @Test
    fun `should force opponent to defend if opponent has multiple forks`() {
        val grid = Grid(
            listOf(
                rowOfCells(0, X, EMPTY, EMPTY),
                rowOfCells(1, EMPTY, O, EMPTY),
                rowOfCells(2, EMPTY, EMPTY, X)
            )
        )

        val nextOptimalMove = computerPlayer.getNextMove(grid)

        assertEquals(Coordinate(0, 1), nextOptimalMove)
    }
}
