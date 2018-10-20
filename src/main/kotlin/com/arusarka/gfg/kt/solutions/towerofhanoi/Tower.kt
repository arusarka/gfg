package com.arusarka.gfg.kt.solutions.towerofhanoi

import java.util.*

data class Tower(private val disks: Stack<Disk>, val name: String) {
    fun displayLines(): List<String> {
        val numberOfPipes = 8 - disks.size
        val displayLines = mutableListOf<String>()

        repeat(numberOfPipes) { displayLines.add(" ".repeat(7).plus("|").plus(" ".repeat(7))) }

        disks.reversed().forEach { displayLines.add(it.display()) }

        return displayLines
    }

    fun putOnTop(disk:Disk) {
        disks.push(disk)
    }

    fun getTopDisk() : Disk = disks.pop()

    fun numberOfDisks(): Int = disks.size
}
