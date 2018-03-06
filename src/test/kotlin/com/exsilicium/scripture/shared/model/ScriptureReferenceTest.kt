package com.exsilicium.scripture.shared.model

import com.exsilicium.scripture.shared.model.Book.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ScriptureReferenceTest {
    @Test fun `Chapter 1 before chapter 2`() {
        assertTrue(ScriptureReference(JOHN, 1) < ScriptureReference(JOHN, 2))
    }

    @Test fun `Compare book equality`() {
        assertTrue(ScriptureReference(REVELATION) == ScriptureReference(REVELATION))
    }

    @Test fun `Compare earlier book is less than later book`() {
        assertTrue(ScriptureReference(GENESIS) < ScriptureReference(EXODUS))
    }

    @Test fun `Compare later book is greater than earlier book`() {
        assertTrue(ScriptureReference(REVELATION) > ScriptureReference(JUDE))
    }

    @Test fun `Book is less than book with chapter`() {
        assertTrue(ScriptureReference(REVELATION) < ScriptureReference(REVELATION, 1))
    }

    @Test fun `Book with chapter is greater than book`() {
        assertTrue(ScriptureReference(REVELATION, 5) > ScriptureReference(REVELATION))
    }

    @Test fun `Book and chapter must be valid`() {
        assertThrows(IllegalArgumentException::class.java) { ScriptureReference(REVELATION, 40) }
    }

    @Test fun `Book and verse must be valid`() {
        assertThrows(IllegalArgumentException::class.java) { ScriptureReference(REVELATION, Verse(2, 30)) }
    }

    @Test fun `Book toString is Book title`() {
        assertEquals(Book.JOHN.title, ScriptureReference(Book.JOHN).toString())
    }

    @Test fun `Book and chapter toString is Book title and chapter`() {
        assertEquals("John 1", ScriptureReference(Book.JOHN, 1).toString())
    }

    @Test fun `Book and chapter range toString is Book title and chapter range`() {
        assertEquals("John 1-4", ScriptureReference(Book.JOHN, ChapterRanges(1..4)).toString())
    }

    @Test fun `Book and chapter ranges toString is Book title and chapter ranges`() {
        assertEquals("John 1-4, 7-9", ScriptureReference(Book.JOHN, ChapterRanges(1..4, 7..9)).toString())
    }

    @Test fun `Book and verse toString is Book title and verse`() {
        assertEquals("John 1:9", ScriptureReference(Book.JOHN, Verse(1, 9)).toString())
    }

    @Test fun `Book and verse range toString is Book title and verse range`() {
        val bookAndVerseRange = ScriptureReference(Book.JOHN, VerseRanges(Verse(1, 9)..Verse(2, 3, 'b')))
        assertEquals("John 1:9-2:3b", bookAndVerseRange.toString())
    }

    @Test fun `Book and verse ranges toString is Book title and verse ranges`() {
        val verseRanges = VerseRanges(Verse(1, 9)..Verse(1, 10), Verse(1, 14)..Verse(1, 14))
        val bookAndVerseRanges = ScriptureReference(Book.JOHN, verseRanges)
        assertEquals("John 1:9-10, 1:14", bookAndVerseRanges.toString())
    }
}
