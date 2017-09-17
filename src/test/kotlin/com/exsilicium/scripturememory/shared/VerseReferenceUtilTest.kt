package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange
import com.exsilicium.scripturememory.shared.model.VerseReference
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class VerseReferenceUtilTest {

    @Test fun `Parse verse reference with invalid book name`() {
        val thrown = assertThrows(IllegalStateException::class.java)
        { VerseReferenceUtil.parse("Johnny 1:1") }
        assertEquals("Could not parse book name", thrown.message)
    }

    @Test fun `Parse verse reference from single verse`() {
        assertEquals(VerseReference(BibleBook.JOHN, 1, listOf(VerseRange(Verse(1)))),
                VerseReferenceUtil.parse("John 1:1"))
    }
}