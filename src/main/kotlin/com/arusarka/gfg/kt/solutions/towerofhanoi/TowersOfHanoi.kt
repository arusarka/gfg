package com.arusarka.gfg.kt.solutions.towerofhanoi

import com.arusarka.gfg.kt.extensions.head
import com.arusarka.gfg.kt.extensions.second
import com.arusarka.gfg.kt.extensions.tail
import java.util.*

class TowersOfHanoi(private val towers: List<Tower>) {
    fun start() {
        displayTowers()
        println("Initial")
        moveDisks(towers.first().numberOfDisks(), towers.first(), towers.last(), towers.second())
    }

    private fun displayTowers() {
        println()
        formatString(towers.map { it.displayLines() }).forEach { println(it) }
        println()
    }

    private fun moveDisks(numberOfDiscsToMove: Int, fromTower: Tower, toTower: Tower, intermediateTower:Tower) {
        if(numberOfDiscsToMove == 1) {
            moveTopDisk(fromTower, toTower)
            return
        }

        moveDisks(numberOfDiscsToMove - 1, fromTower, intermediateTower, toTower)
        moveTopDisk(fromTower, toTower)
        moveDisks(numberOfDiscsToMove - 1, intermediateTower, toTower, fromTower)
    }

    private fun moveTopDisk(
        fromTower: Tower,
        toTower: Tower
    ) {
        val disk = fromTower.getTopDisk()
        toTower.putOnTop(disk)
        displayTowers()
        println("Moved ${disk} from ${fromTower.name} to ${toTower.name}")
    }

    private fun formatString(listOfLines: List<List<String>>): List<String> {
        if (listOfLines.all { it.isEmpty() }) return listOf()
        val formattedLines = mutableListOf(listOfLines.joinToString("") { it.head })
        formattedLines.addAll(formatString(listOfLines.map { it.tail }))
        return formattedLines
    }
}

fun main(args: Array<String>) {

    val discs = Stack<Disk>()
    discs.push(Disk(4))
    discs.push(Disk(3))
    discs.push(Disk(2))
    discs.push(Disk(1))

    val towerA = Tower(discs, "A")
    val towerB = Tower(Stack(), "B")
    val towerC = Tower(Stack(), "C")

    TowersOfHanoi(listOf(towerA, towerB, towerC))
        .start()
}
