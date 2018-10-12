package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.tictactoe.Cell.CellState.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import sun.invoke.empty.Empty

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
@DisplayName("Grid")
class GridTest {

    private fun List<Path>.second() = this[1]
    private fun List<Path>.third() = this[2]

    lateinit var grid: Grid

    @Mock
    lateinit var board: TicTacToeBoard

    @BeforeEach
    internal fun setUp() {
        grid = Grid(
            listOf(
                rowOfCells(0, firstCellState = X),
                rowOfCells(1, EMPTY, O, O),
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
}
