package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class VerseRangesTest {
    @Test fun `Require non-empty ranges`() {
        assertThrows(IllegalArgumentException::class.java) { VerseRanges(sortedSetOf()) }
    }

    @Test fun `Secondary constructor sorts input`() {
        assertEquals(VerseRanges(Verse(1, 1)..Verse(1, 5), Verse(1, 8)..Verse(1, 10)),
                VerseRanges(Verse(1, 8)..Verse(1, 10), Verse(1, 1)..Verse(1, 5)))
    }

    @Test fun `VerseRanges with earlier start is less than later verse`() {
        val threeOneThroughFive = VerseRanges(Verse(3, 1)..Verse(3, 5))
        val threeFour = VerseRanges(VerseRange(Verse(3, 4)))
        assertTrue(threeOneThroughFive < threeFour)
    }

    @Test fun `VerseRanges with earlier start is less than VerseRanges with later start`() {
        val oneThreeThroughSix = VerseRanges(Verse(1, 3)..Verse(1, 6))
        val oneFourAndFive = VerseRanges(Verse(1, 4)..Verse(1, 5))
        assertTrue(oneThreeThroughSix < oneFourAndFive)
    }

    @Test fun `VerseRanges with same start chapter as ChapterRanges is equal if VerseRanges starts at verse 1`() {
        val oneOneThroughSix = VerseRanges(Verse(1, 1)..Verse(1, 6))
        val chaptersOneAndTwo = ChapterRanges(ChapterRange(1, 2))
        assertTrue(oneOneThroughSix.compareTo(chaptersOneAndTwo) == 0)
    }

    @Test
    fun `VerseRanges with same start chapter as ChapterRanges is greater if VerseRanges doesn't start at verse 1`() {
        val oneThreeThroughSix = VerseRanges(Verse(1, 3)..Verse(1, 6))
        val chapterOne = ChapterRanges(ChapterRange(1))
        assertTrue(oneThreeThroughSix > chapterOne)
    }

    @Test
    fun `VerseRanges with longer ranges is greater than VerseRanges with shorter ranges`() {
        val twoRanges = VerseRanges(Verse(1, 3)..Verse(1, 6), Verse(1, 9)..Verse(1, 10))
        val oneRange = VerseRanges(Verse(1, 3)..Verse(1, 6))
        assertTrue(twoRanges > oneRange)
    }

    @Test
    fun `VerseRanges with more ranges is not necessarily greater than VerseRanges with fewer ranges`() {
        val twoRanges = VerseRanges(Verse(1, 3)..Verse(1, 6), Verse(1, 9)..Verse(1, 10))
        val oneRange = VerseRanges(Verse(1, 3)..Verse(1, 20))
        assertTrue(twoRanges < oneRange)
    }

    @Test
    fun `VerseRanges with shorter ranges is less than VerseRanges with longer ranges`() {
        val twoRanges = VerseRanges(Verse(1, 3)..Verse(1, 6), Verse(1, 9)..Verse(1, 10))
        val oneRange = VerseRanges(Verse(1, 3)..Verse(1, 6))
        assertTrue(oneRange < twoRanges)
    }

    @Test
    fun `VerseRanges with fewer ranges is not necessarily less than VerseRanges with more ranges`() {
        val twoRanges = VerseRanges(Verse(1, 3)..Verse(1, 6), Verse(1, 9)..Verse(1, 10))
        val oneRange = VerseRanges(Verse(1, 3)..Verse(1, 20))
        assertTrue(twoRanges < oneRange)
    }
}
