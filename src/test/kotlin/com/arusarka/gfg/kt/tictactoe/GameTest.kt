package com.arusarka.gfg.kt.tictactoe

import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GameTest {

    @RelaxedMockK
    lateinit var board: TicTacToeBoard
    @RelaxedMockK
    lateinit var player1: Player
    @RelaxedMockK
    lateinit var player2: Player
    @RelaxedMockK
    lateinit var console: Console
    @RelaxedMockK
    lateinit var grid: Grid
    lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game(board, listOf(player1, player2), console)
        every { board.grid } returns grid
        every { player1.state } returns CellState.X
        every { player2.state } returns CellState.O
        every { player1.name } returns "player1"
        every { player2.name } returns "player2"
    }

    @Test
    fun `should be played till board is open`() {
        every { board.isStillOpen() } returns true andThen true andThen false

        game.start()

        verify(exactly = 1) { player1.getNextMove(grid) }
        verify(exactly = 1) { player2.getNextMove(grid) }
    }

    @Test
    fun `should set the move returned by the player on the board`() {
        every { board.isStillOpen() } returns true andThen false
        every { player1.getNextMove(grid) } returns Coordinate(1, 2)

        game.start()

        verify(exactly = 0) { player2.getNextMove(grid) }
        verify { board.setCoordinate(CellState.X, Coordinate(1, 2), game) }
    }

    @Test
    fun `should declare the winner on win`() {
        game.onWin()

        verify { console.write(match { it.contains("player1 (X) has(have) won") }) }
    }

    @Test
    fun `should declare a draw`() {
        every { board.isStillOpen() } returns false

        game.start()

        verify { console.write(match { it.contains("It's a draw") }) }
    }
}
