package com.exsilicium.scripture.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChapterRangesTest {

    @Test fun `Require non-empty ranges`() {
        assertThrows(IllegalArgumentException::class.java) { ChapterRanges() }
    }

    @Test fun `Require ranges start at one or greater`() {
        assertThrows(IllegalArgumentException::class.java) { ChapterRanges(0..3) }
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

    @Test
    fun `ChapterRanges with longer ranges is greater than ChapterRanges with shorter ranges`() {
        val twoRanges = ChapterRanges(1..5, 9..10)
        val oneRange = ChapterRanges(1..20)
        assertTrue(oneRange > twoRanges)
    }

    @Test
    fun `ChapterRanges with more ranges is not necessarily greater than ChapterRanges with fewer ranges`() {
        val twoRanges = ChapterRanges(1..5, 9..10)
        val oneRange = ChapterRanges(1..9)
        assertTrue(oneRange > twoRanges)
    }

    @Test
    fun `ChapterRanges with shorter ranges is less than ChapterRanges with longer ranges`() {
        val twoRanges = ChapterRanges(1..5, 9..20)
        val oneRange = ChapterRanges(1..9)
        assertTrue(twoRanges > oneRange)
    }

    @Test
    fun `ChapterRanges with fewer ranges is not necessarily less than ChapterRanges with more ranges`() {
        val twoRanges = ChapterRanges(1..5, 9..10)
        val oneRange = ChapterRanges(1..9)
        assertTrue(twoRanges < oneRange)
    }

    @Test fun `All chapter ranges must be valid for a given Book`() {
        assertFalse(ChapterRanges(1..2).isValid(Book.JUDE))
    }
}
