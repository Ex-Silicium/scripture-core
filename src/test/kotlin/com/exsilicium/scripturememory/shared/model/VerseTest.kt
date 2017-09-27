package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VerseTest {
    @Test fun `Verse 1 less than verse 2`() = assertTrue(Verse(1, 1) < Verse(1, 2))

    @Test fun `Verse 1 equals verse 1`() = assertTrue(Verse(1, 1).compareTo(Verse(1, 1)) == 0)

    @Test fun `Verse 2 greater than verse 1`() = assertTrue(Verse(1, 2) > Verse(1, 1))

    @Test fun `Verse 1a greater than verse 1`() = assertTrue(Verse(1, 1, 'a') > Verse(1, 1))

    @Test fun `Verse 1a equals verse 1a`() = assertTrue(Verse(1, 1, 'a').compareTo(Verse(1, 1, 'a')) == 0)

    @Test fun `Verse 1a less than verse 1b`() = assertTrue(Verse(1, 1, 'a') < Verse(1, 1, 'b'))

    @Test fun `Chapter 1 less than chapter 2`() = assertTrue(Verse(1, 1) < Verse(2, 1))

    @Test fun `Chapter 2 greater than chapter 1`() = assertTrue(Verse(2, 1) > Verse(1, 1))

    @Test fun `Verse 5 minus Verse 1 is 4 verses`() = assertEquals(4, Verse(1, 5) - Verse(1, 1))

    @Test fun `Verse with different chapter fails minus`() {
        assertThrows(UnsupportedOperationException::class.java) { Verse(2, 2) - Verse(1, 1) }
    }
}
