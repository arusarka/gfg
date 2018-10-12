package com.arusarka.gfg.kt.extensions

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntExtensionsKtTest {
    @Test
    fun `should consider 101 as a palindromic number`() {
        assertTrue(101.isPalindrome())
    }

    @Test
     fun `should not consider 42 as a palindromic number`() {
        assertFalse(42.isPalindrome())
    }

    @Test
    fun `should consider 9 as a palindromic number`() {
        assertTrue(9.isPalindrome())
    }

    @Test
     fun `should not consider negative numbers as palindrome`() {
        assertFalse((-44).isPalindrome())
    }
}
