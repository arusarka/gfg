package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.tictactoe.Cell.CellState.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Grid")
class GridTest {

    private fun List<Path>.second() = this[1]
    private fun List<Path>.third() = this[2]

    lateinit var grid: Grid

    @BeforeEach
    internal fun setUp() {
        grid = Grid(
            listOf(
                rowOfCells(0, firstCellState = X),
                rowOfCells(1, firstCellState = EMPTY, secondCellState = O, thirdCellState = O),
                rowOfCells(2)
            )
        )
    }

    @Test
    fun `should be able to return the paths a cell's coordinate is part of`() {
        val paths = grid.pathsWithCoordinate(grid[0, 0].position)

        assertEquals(3, paths.size)
        assertEquals(grid.rows.first(), paths.first())
        assertEquals(grid.columns.first(), paths.second())
        assertEquals(grid.diagonals.first(), paths.third())
    }

    @Test
    fun `should be able to set the state of a coordinate`() {
        assertNotSame(X, grid[0, 1].state)

        grid.setCellState(Coordinate(0, 1), X)

        assertSame(X, grid[0, 1].state)
    }

    @Nested
    @DisplayName("validations")
    inner class Validations {
        @Test
        fun `coordinate should be empty`() {
            assertFalse(grid.isValidMove(Coordinate(0, 0)))
        }

        @Test
        fun `coordinate row should not be greater than 2`() {
            assertFalse(grid.isValidMove(Coordinate(3,0)))
        }

        @Test
        fun `coordinate row should not be less than 0`() {
            assertFalse(grid.isValidMove(Coordinate(-1,0)))
        }

        @Test
        fun `coordinate column should not be greater than 2`() {
            assertFalse(grid.isValidMove(Coordinate(0,3)))
        }

        @Test
        fun `coordinate column should not be less than 0`() {
            assertFalse(grid.isValidMove(Coordinate(0,-1)))
        }
    }
}
