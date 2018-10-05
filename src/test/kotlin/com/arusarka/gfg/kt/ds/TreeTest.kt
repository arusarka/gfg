package com.arusarka.gfg.kt.ds

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
@DisplayName("A tree")
class TreeTest {

    @Mock
    lateinit var leftTreeMock: Tree

    @Mock
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
            Mockito.`when`(leftTreeMock.height()).thenReturn(2)
            Mockito.`when`(rightTreeMock.height()).thenReturn(5)

            val tree = Tree(42, leftTreeMock, rightTreeMock)

            assertEquals(6, tree.height())
            Mockito.verify(leftTreeMock).height()
            Mockito.verify(rightTreeMock).height()
        }
    }
}
