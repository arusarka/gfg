package com.arusarka.gfg.kt.tictactoe

import com.arusarka.gfg.kt.extensions.get
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Path")
class PathTest {
    @Test
    fun `should be able to return null if there are no winning position`() {
        val path =
            Path(
                listOf(
                    Cell(0, 0, CellState.X),
                    Cell(0, 1, CellState.O),
                    Cell(0, 2, CellState.EMPTY)
                )
            )

        assertNull(path.winningPositionFor(CellState.O))
    }

    @Test
    fun `should be able to return the winning position`() {
        val path =
            Path(
                listOf(
                    Cell(0, 0, CellState.X),
                    Cell(0, 1, CellState.EMPTY),
                    Cell(0, 2, CellState.X)
                )
            )

        assertEquals(Coordinate(0, 1), path.winningPositionFor(CellState.X))
    }

    @Nested
    @DisplayName("list")
    inner class PathListTest {
        @Test
        fun `should be able to get a cell from a list of list of cells`() {
            val cell = Cell(0, 1)
            val paths = listOf(
                Path(listOf(Cell(0, 0), cell)),
                Path(listOf(Cell(1, 0), Cell(1, 1)))
            )

            assertSame(cell, paths[0, 1])
        }
    }
}
