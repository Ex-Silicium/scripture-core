package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class VerseRangeTest {
    @Test fun `Verse range default constructor`() {
        assertEquals(VerseRange(Verse(1), Verse(1)), VerseRange(Verse(1)))
    }

    @Test fun `Require range start less than or equal to end`() {
        assertThrows(IllegalArgumentException::class.java) { VerseRange(Verse(2), Verse(1)) }
    }
}