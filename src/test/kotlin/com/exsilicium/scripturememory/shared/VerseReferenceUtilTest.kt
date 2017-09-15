package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange
import com.exsilicium.scripturememory.shared.model.VerseReference
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class VerseReferenceUtilTest {

    @Test
    fun `Parse verse reference with invalid book name`() {
        val thrown = Assertions.assertThrows(IllegalStateException::class.java,
                { VerseReferenceUtil.parse("Jon 1:1") })
        Assertions.assertEquals("Could not parse book name", thrown.message)
    }

    @Test
    fun `Parse verse reference from single verse`() {
        val expectedVerseReference = VerseReference(BibleBook.JOHN, 1, listOf(VerseRange(Verse(1))))
        Assertions.assertEquals(expectedVerseReference, VerseReferenceUtil.parse("John 1:1"))
    }
}