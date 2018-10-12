package com.arusarka.gfg.kt.tictactoe

class Path(private val cells: List<Cell>) : AbstractList<Cell>() {
    override fun get(index: Int): Cell {
        return cells[index]
    }

    override val size: Int
        get() = cells.size

    fun winningPositionFor(cellState: Cell.CellState): Coordinate? {
        val winnable = (this.count { it.state == cellState } == 2)
        return if (winnable) this.firstOrNull { it.state == Cell.CellState.EMPTY }?.position else null
    }

    fun containsCellWithCoordinate(coordinate: Coordinate): Boolean {
        return cells.map { it.position }.contains(coordinate)
    }

    fun allCellsHaveState(cellState: Cell.CellState): Boolean {
        return all { cell: Cell -> cell.state == cellState }
    }
}
