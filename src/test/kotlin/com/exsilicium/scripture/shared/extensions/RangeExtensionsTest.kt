package com.exsilicium.scripture.shared.extensions

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class RangeExtensionsTest {

    @Test fun `Verify empty range`() {
        assertTrue((0..0).isEmptyRange())
    }

    @Test fun `Verify non-empty range`() {
        assertFalse((0..2).isEmptyRange())
    }
}