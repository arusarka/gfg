package com.arusarka.gfg.kt.tictactoe

import kotlin.system.exitProcess

class Game(private val board: TicTacToeBoard, players: List<Player>) {
    val player1 = players.first()
    val player2 = players[1]

    private var currentPlayer: Player = player1

    fun start() {
        println(board.toString())
        while (board.isStillOpen()) {
            val nextMove = currentPlayer.getNextMove(board.grid)
            board.setCoordinate(currentPlayer.state, nextMove, this)
            println("\n================")
            println(board.toString())
            swapPlayers()
        }
    }

    fun onWin(cellState: Cell.CellState) {
        println("${currentPlayer.name} (${currentPlayer.state}) has won")

    }

    private fun swapPlayers() {
        if (currentPlayer == player1) currentPlayer = player2 else currentPlayer = player1
    }
}

private fun emptyRow(rowNumber: Int) = listOf(Cell(rowNumber, 0), Cell(rowNumber, 1), Cell(rowNumber, 2))

fun main(args: Array<String>) {
    val grid = Grid(
        listOf(
            emptyRow(0),
            emptyRow(1),
            emptyRow(2)
        )
    )
    val ticTacToeBoard = TicTacToeBoard(grid)

    Game(ticTacToeBoard, listOf(HumanPlayer(), ComputerPlayer()))
        .start()
}
