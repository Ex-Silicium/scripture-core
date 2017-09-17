package com.exsilicium.scripturememory.shared.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows

internal class BibleBookDeserializationTest {

    @Test fun `Parse invalid book name`() {
        assertThrows(IllegalStateException::class.java, { BibleBook.parse("Johnny") }).let {
            assertEquals("Could not parse book name", it.message)
        }
    }

    @Test fun `Parse Genesis`() {
        assertEquals(BibleBook.GENESIS, BibleBook.parse("Genesis"))
        assertEquals(BibleBook.GENESIS, BibleBook.parse("Gen"))
        assertEquals(BibleBook.GENESIS, BibleBook.parse("Ge"))
        assertEquals(BibleBook.GENESIS, BibleBook.parse("Gn"))
    }

    @Test fun `Parse uppercase book`() {
        assertEquals(BibleBook.REVELATION, BibleBook.parse("THE REVELATION"))
    }

    @Test fun `Parse book with whitespace`() {
        assertEquals(BibleBook.MATTHEW, BibleBook.parse(" Matt  "))
    }

    @Test fun `Verify no duplicate abbreviations`() {
        BibleBook.values().flatMap { it.abbreviations }.let {
            assertEquals(it, it.distinct())
        }
    }
}