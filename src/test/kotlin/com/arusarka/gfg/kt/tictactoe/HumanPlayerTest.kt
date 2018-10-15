package com.arusarka.gfg.kt.tictactoe

import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@DisplayName("Human player")
@ExtendWith(MockKExtension::class)
class HumanPlayerTest {

    @RelaxedMockK
    lateinit var console: Console
    @RelaxedMockK
    lateinit var grid: Grid

    lateinit var humanPlayer: HumanPlayer

    @BeforeEach
    fun setUp() {
        humanPlayer = HumanPlayer(console)

        every { grid.isValidMove(any()) } returns true
        every { console.read() } returns "2,2"
    }

    @Nested
    @DisplayName("when getting next move")
    inner class GetNextMove {
        @Test
        fun `should display explanatory message first time`() {
            humanPlayer.getNextMove(grid)

            verify {
                console.write(
                    "\n" +
                            "Enter coordinate for X in the format x,y (with the comma in between 1,1 is the top left corner and 3,3 is the bottom right corner) : "
                )
            }
        }

        @Test
        fun `should display storter message on subsequent moves`() {
            repeat(2) { humanPlayer.getNextMove(grid) }

            verify {
                console.write(
                    "\n" +
                            "Enter coordinate for X : "
                )
            }
        }

        @Test
        fun `should get move from console`() {
            every { console.read() } returns "1,2"

            humanPlayer.getNextMove(grid)

            verify { console.read() }
        }

        @Test
        fun `should substract one from both x and y coordinates read from console`() {
            every { console.read() } returns "2,2"

            val coordinate = humanPlayer.getNextMove(grid)

            assertEquals(Coordinate(1, 1), coordinate)
        }

        @Test
        fun `should get move again if move is invalid`() {
            every { grid.isValidMove(Coordinate(1, 2)) } returns false
            every { console.read() } returns "2,3" andThen "1,3"

            humanPlayer.getNextMove(grid)

            verify { grid.isValidMove(Coordinate(1, 2)) }
            verify(exactly = 2) { console.read() }
        }
    }
}
