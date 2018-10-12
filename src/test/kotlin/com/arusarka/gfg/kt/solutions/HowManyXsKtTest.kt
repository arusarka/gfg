package com.arusarka.gfg.kt.solutions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("how many Xs")
class HowManyXsKtTest {
    @Test
    fun `should return 0 if lower limit and upper limit are same`() {
        val howManyXs = howManyXs(42, 1234, 1234)
        assertEquals(0, howManyXs)
    }

    @Test
    fun `should return 1 for number of times 3 gets repeated between 1 and 4`() {
        val howManyXs = howManyXs(3, 1, 4)

        assertEquals(1, howManyXs)
    }

    @Test
    fun `should return 35 for number of times 3 gets repeated between 100 and 250`() {
        val howManyXs = howManyXs(3, 100, 250)

        assertEquals(35, howManyXs)
    }

    @Test
    fun `should throw exception if x is less than 0`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java, {
            howManyXs(-1, 100, 250)
        })

        assertEquals("value of x should be from 0 to 9, provided is -1", exception.message)
    }

    @Test
    fun `should throw exception if x is more than 9`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java, {
            howManyXs(10, 100, 250)
        })

        assertEquals("value of x should be from 0 to 9, provided is 10", exception.message)
    }
}
