package com.arusarka.gfg.kt.extensions

import com.arusarka.gfg.kt.tictactoe.Cell
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

internal class ListExtenstionsKtTest {

    lateinit var list: List<Int>

    @Before
    fun setUp() {
        list = listOf<Int>(1, 2, 3)
    }

    @Test
    fun `should get the head of a list`() {
        assertEquals(1, list.head)
    }

    @Test
    fun `should get the tail of a list`() {
        assertEquals(listOf(2, 3), list.tail)
    }

    @Test
    fun `should be able to tranpose a list of list`() {
        assertEquals(
            listOf(listOf(1, 4), listOf(2, 5), listOf(3, 6)),
            listOf(listOf(1, 2, 3), listOf(4, 5, 6)).tranpose()
        )
    }

    @Test
    fun `should be able to get a cell from a list of list of cells`() {
        val cellAt_0_1 = Cell(0, 1)
        val list = listOf(listOf(Cell(0, 0), cellAt_0_1), listOf(Cell(1, 0), Cell(1, 1)))

        assertSame(cellAt_0_1, list[0, 1])
    }
}
