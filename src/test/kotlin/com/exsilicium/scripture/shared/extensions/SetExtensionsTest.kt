package com.exsilicium.scripture.shared.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SetExtensionsTest {

    @Test fun `Single element in set`() {
        assertEquals("1-3", setOf(1..3).createJoinedString())
    }

    @Test fun `Multiple elements in set `() {
        assertEquals("1-3, 5-6", setOf(1..3, 5..6).createJoinedString())
    }
}