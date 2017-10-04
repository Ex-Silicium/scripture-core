package com.exsilicium.scripture.shared.extensions

import com.exsilicium.scripture.shared.model.ChapterRanges
import com.exsilicium.scripture.shared.model.Verse
import com.exsilicium.scripture.shared.model.VerseRanges
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class LocationExtensionsTest {

    @Test fun `Compare ChapterRanges with earlier start to ChapterRanges with later start`() {
        assertTrue(ChapterRanges(1..4).compareChapterRanges(ChapterRanges(2..3)) < 0)
    }

    @Test fun `Compare equal ChapterRanges`() {
        assertEquals(0, ChapterRanges(1..4).compareChapterRanges(ChapterRanges(1..4)))
    }

    @Test fun `Compare two ChapterRanges with same start - larger range is greater`() {
        assertTrue(ChapterRanges(1..4).compareChapterRanges(ChapterRanges(1..3)) > 0)
    }

    @Test fun `Compare two ChapterRanges with same start - smaller range is lesser`() {
        assertTrue(ChapterRanges(1..4).compareChapterRanges(ChapterRanges(1..3, 6..8)) < 0)
    }

    @Test fun `Compare equal ChapterRanges with multiple ranges`() {
        assertEquals(0, ChapterRanges(1..5).compareChapterRanges(ChapterRanges(1..3, 6..7)))
    }

    @Test fun `Compare VerseRanges with earlier start to VerseRanges with later start`() {
        val verseOneToTwo = VerseRanges(Verse(1, 1)..Verse(1, 2))
        val verseTwoToThree = VerseRanges(Verse(1, 2)..Verse(1, 3))
        assertTrue(verseOneToTwo.compareVerseRanges(verseTwoToThree) < 0)
    }

    @Test fun `Compare equal VerseRanges`() {
        assertEquals(0, VerseRanges(Verse(1, 1)..Verse(1, 2)).compareVerseRanges(VerseRanges(Verse(1, 1)..Verse(1, 2))))
    }

    @Test fun `Compare two VerseRanges with same start - larger range is greater`() {
        val verseOneToThree = VerseRanges(Verse(1, 1)..Verse(1, 3))
        val verseOneToTwo = VerseRanges(Verse(1, 1)..Verse(1, 2))
        assertTrue(verseOneToThree.compareVerseRanges(verseOneToTwo) > 0)
    }

    @Test fun `Compare two VerseRanges with same start - smaller range is lesser`() {
        val verseOneToThree = VerseRanges(Verse(1, 1)..Verse(1, 3))
        val verseOneToTwo = VerseRanges(Verse(1, 1)..Verse(1, 2))
        assertTrue(verseOneToTwo.compareVerseRanges(verseOneToThree) < 0)
    }

    @Test fun `Compare equal VerseRanges with multiple ranges`() {
        val verseOneToThreeAndFiveToEight = VerseRanges(Verse(1, 1)..Verse(1, 3), Verse(1, 5)..Verse(1, 8))
        val verseOneToSeven = VerseRanges(Verse(1, 1)..Verse(1, 7))
        assertEquals(0, verseOneToThreeAndFiveToEight.compareVerseRanges(verseOneToSeven))
    }
}