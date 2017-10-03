package com.exsilicium.scripture.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BookTest {
    @Test fun `Old testament book check`() {
        assertTrue(Book.GENESIS.isOldTestament())
        assertTrue(Book.MALACHI.isOldTestament())
    }

    @Test fun `New testament book check`() = assertFalse(Book.MATTHEW.isOldTestament())

    @Test fun `Chapter count`() {
        assertEquals(1, Book.JUDE.chapterCount)
        assertEquals(150, Book.PSALMS.chapterCount)
    }

    @Test fun `Negative chapter`() {
        assertThrows(IllegalArgumentException::class.java) { Book.JUDE.isValidChapter(-1) }
    }

    @Test fun `Invalid chapter`() = assertFalse(Book.JUDE.isValidChapter(2))

    @Test fun `Valid chapter`() = assertTrue(Book.JUDE.isValidChapter(1))

    @Test fun `Invalid chapter reference`() = assertFalse(Book.JUDE.isValidChapterRange(ChapterRange(2)))

    @Test fun `Invalid chapter range reference`() = assertFalse(Book.JUDE.isValidChapterRange(1..2))

    @Test fun `Valid chapter reference`() = assertTrue(Book.JUDE.isValidChapterRange(ChapterRange(1)))

    @Test fun `Valid ChapterRange reference`() = assertTrue(Book.PSALMS.isValidChapterRange(ChapterRange(1, 150)))

    @Test fun `Chapter out of bounds`() {
        val jude = Book.JUDE
        assertThrows(IllegalArgumentException::class.java) { jude.versesInChapter(0) }
        val outOfBoundsException = assertThrows(IndexOutOfBoundsException::class.java) { jude.versesInChapter(2) }
        assertEquals("Chapter 2 does not exist in Jude.", outOfBoundsException.message)
    }

    @Test fun `Invalid verse chapter`() = assertFalse(Book.JUDE.isValid(Verse(2, 1)))

    @Test fun `Invalid verse reference`() = assertFalse(Book.JUDE.isValid(Verse(1, 26)))

    @Test fun `Valid verse reference`() = assertTrue(Book.JUDE.isValid(Verse(1, 25)))

    @Test fun `Get number of verses in valid chapter`() = assertEquals(6, Book.PSALMS.versesInChapter(150))
}
