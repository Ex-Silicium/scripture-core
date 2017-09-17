package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class VerseTest {
    @Test fun `Verse 1 less than verse 2`() = assertTrue(Verse(1) < Verse(2))

    @Test fun `Verse 1 equals verse 1`() = assertTrue(Verse(1) == Verse(1))

    @Test fun `Verse 2 greater than verse 1`() = assertTrue(Verse(2) > Verse(1))

    @Test fun `Verse 1a greater than verse 1`() = assertTrue(Verse(1, 'a') > Verse(1))

    @Test fun `Verse 1a equals verse 1a`() = assertTrue(Verse(1, 'a') == Verse(1, 'a'))

    @Test fun `Verse 1a less than verse 1b`() = assertTrue(Verse(1, 'a') < Verse(1, 'b'))
}