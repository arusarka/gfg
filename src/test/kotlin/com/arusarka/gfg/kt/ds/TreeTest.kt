package com.arusarka.gfg.kt.ds

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
@DisplayName("A tree")
class TreeTest {

    @MockK
    lateinit var leftTreeMock: Tree

    @MockK
    lateinit var rightTreeMock: Tree

    @Nested
    @DisplayName("height")
    inner class HeightTests {
        @Test
        fun `should be 0 if there is no root node`() {
            val tree = Tree()

            assertEquals(0, tree.height())
        }

        @Test
        fun `should be 1 if there is only one root node`() {
            val tree = Tree(42, null, null)

            assertEquals(1, tree.height())
        }

        @Test
        fun `should be 1 + greater of the two subtrees`() {
            every { leftTreeMock.height() } returns 2
            every { rightTreeMock.height() } returns 5

            val tree = Tree(42, leftTreeMock, rightTreeMock)

            assertEquals(6, tree.height())
            verify { leftTreeMock.height() }
            verify { rightTreeMock.height() }
        }
    }
}
