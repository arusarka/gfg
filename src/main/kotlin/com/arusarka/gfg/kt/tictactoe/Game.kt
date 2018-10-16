package com.arusarka.gfg.kt.tictactoe

class Game(
    private val board: TicTacToeBoard,
    players: List<Player>,
    private val console: Console
) {
    private var firstTime: Boolean = true
    private val player1 = players.first()
    private val player2 = players[1]
    private var won = false

    private var currentPlayer: Player = player1

    private val separator: String = "\n================\n"

    fun start() {
        while (board.isStillOpen()) {
            if (!firstTime)
                console.write(separator)
            println(board.toString())
            val nextMove = currentPlayer.getNextMove(board.grid)
            board.setCoordinate(currentPlayer.state, nextMove, this)
            if (firstTime) firstTime = false
            swapPlayers()
        }
        if (!won) onDraw()
    }

    fun onWin() {
        with(console) {
            write(separator)
            write(board.toString())
            write("\n${currentPlayer.name} (${currentPlayer.state}) has(have) won")
        }
        won = true
    }

    private fun swapPlayers() {
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    private fun onDraw() {
        with(console) {
            write(separator)
            write(board.toString())
            write("\nIt's a draw!\n")
        }
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

    Game(ticTacToeBoard, listOf(HumanPlayer(), ComputerPlayer()), Console())
        .start()
}
