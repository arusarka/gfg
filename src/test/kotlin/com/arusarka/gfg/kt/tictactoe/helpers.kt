package com.arusarka.gfg.kt.tictactoe

fun rowOfCells(
    rowNumber: Int,
    firstCellState: Cell.CellState = Cell.CellState.EMPTY,
    secondCellState: Cell.CellState = Cell.CellState.EMPTY,
    thirdCellState: Cell.CellState = Cell.CellState.EMPTY
) = listOf(
    Cell(rowNumber, 0, firstCellState),
    Cell(rowNumber, 1, secondCellState),
    Cell(rowNumber, 2, thirdCellState)
)
