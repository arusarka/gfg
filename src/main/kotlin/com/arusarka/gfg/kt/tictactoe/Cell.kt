package com.arusarka.gfg.kt.tictactoe

class Cell(val position: Coordinate, var state: CellState) {
    fun isEmpty(): Boolean = state.isEmpty

    fun resetState() {
        state = CellState.EMPTY
    }

    override fun toString(): String {
        return state.toString()
    }

    constructor(coordinate: Coordinate) : this(coordinate, CellState.EMPTY)
    constructor(x: Int, y: Int) : this(Coordinate(x, y))
    constructor(x: Int, y: Int, state: CellState) : this(Coordinate(x, y), state)

    enum class CellState {
        EMPTY {
            override val isEmpty: Boolean = true
            override fun opponent() = EMPTY
            override fun toString(): String {
                return " "
            }
        },

        O {
            override val isEmpty: Boolean = false
            override fun opponent() = X
            override fun toString(): String {
                return "O"
            }
        },

        X {
            override val isEmpty: Boolean = false
            override fun opponent() = O
            override fun toString(): String {
                return "X"
            }
        };

        abstract val isEmpty: Boolean
        abstract fun opponent(): CellState
    }
}
