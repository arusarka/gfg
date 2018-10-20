package com.arusarka.gfg.kt.extensions

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

fun <T> List<T>.second(): T {
    if (this.size < 2) throw NoSuchElementException("List size is ${size}")
    return this[1]
}

fun <T> List<List<T>>.tranpose(): List<List<T>> {
    return when (this.all { it.isEmpty() }) {
        true -> emptyList()
        else -> mutableListOf(this.map { it.head }).plus(this.map { it.tail }.tranpose())
    }
}

operator fun <T> List<List<T>>.get(index1: Int, index2: Int): T = this[index1][index2]
