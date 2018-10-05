package com.arusarka.gfg.kt.ds

class Tree constructor(private val currentVal: Int?, private val leftTree: Tree?, private val rightTree: Tree?) {
    fun height(): Int {
        return when (currentVal) {
            null -> 0
            else -> {
                1 + maxOf(leftTree?.height() ?: 0, rightTree?.height() ?: 0)
            }
        }
    }

    internal constructor() : this(currentVal = null, leftTree = null, rightTree = null)
}
