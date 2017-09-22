package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows

internal class BookDeserializationTest {

    @Test fun `Parse invalid book name`() {
        assertThrows(IllegalStateException::class.java, { Book.parse("Johnny") }).let {
            assertEquals("Could not parse book name", it.message)
        }
    }

    @Test fun `Parse Genesis`() {
        assertEquals(Book.GENESIS, Book.parse("Genesis"))
        assertEquals(Book.GENESIS, Book.parse("Gen"))
        assertEquals(Book.GENESIS, Book.parse("Ge"))
        assertEquals(Book.GENESIS, Book.parse("Gn"))
    }

    @Test fun `Parse uppercase book`() {
        assertEquals(Book.REVELATION, Book.parse("THE REVELATION"))
    }

    @Test fun `Parse book with whitespace`() {
        assertEquals(Book.MATTHEW, Book.parse(" Matt  "))
    }

    @Test fun `Verify no duplicate abbreviations`() {
        Book.values().flatMap { it.abbreviations }.let {
            assertEquals(it, it.distinct())
        }
    }
}