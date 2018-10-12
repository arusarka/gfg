package com.arusarka.gfg.kt.solutions

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Closest palindromic number")
class ClosestPalindromicNumberKtTest {
    @Test
    fun `should be 9 for input 9`() {
        assertEquals(9, closestPalindromicNumber(9))
    }

    @Test
     fun `should be 484 for 489`() {
        assertEquals(484, closestPalindromicNumber(489))
    }
}
