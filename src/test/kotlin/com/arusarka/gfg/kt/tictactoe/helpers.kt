package com.arusarka.gfg.kt.tictactoe

fun rowOfCells(
    rowNumber: Int,
    firstCellState: CellState = CellState.EMPTY,
    secondCellState: CellState = CellState.EMPTY,
    thirdCellState: CellState = CellState.EMPTY
) = listOf(
    Cell(rowNumber, 0, firstCellState),
    Cell(rowNumber, 1, secondCellState),
    Cell(rowNumber, 2, thirdCellState)
)
