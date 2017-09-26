package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChapterRangesTest {

    @Test fun `Require non-empty ranges`() {
        assertThrows(IllegalArgumentException::class.java) { ChapterRanges() }
    }

    @Test fun `Secondary constructor sorts input`() {
        assertEquals(ChapterRanges(1..2, 4..5), ChapterRanges(4..5, 1..2))
    }

    @Test fun `ChapterRanges with earlier start is less than later chapter`() {
        val threeThroughFive = ChapterRanges(3..5)
        val four = ChapterRanges(ChapterRange(4))
        assertTrue(threeThroughFive < four)
    }

    @Test fun `ChapterRanges with earlier start is less than ChapterRanges with later start`() {
        val threeThroughFive = ChapterRanges(3..5)
        val fourAndFive = ChapterRanges(4..5)
        assertTrue(threeThroughFive < fourAndFive)
    }

    @Test fun `ChapterRanges with same start chapter as VerseRanges is equal if VerseRanges starts at verse 1`() {
        val threeThroughFive = ChapterRanges(3..5)
        val threeOneThroughSeventeen = VerseRanges(VerseRange(Verse(3, 1), Verse(3, 17)))
        assertTrue(threeThroughFive.compareTo(threeOneThroughSeventeen) == 0)
    }

    @Test
    fun `ChapterRanges with same start chapter as VerseRanges is less if VerseRanges doesn't start at verse 1`() {
        val threeThroughFive = ChapterRanges(3..5)
        val threeSixteen = VerseRanges(VerseRange(Verse(3, 16)))
        assertTrue(threeThroughFive < threeSixteen)
    }
}
