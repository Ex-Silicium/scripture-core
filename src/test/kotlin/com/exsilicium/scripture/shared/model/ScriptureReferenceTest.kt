package com.exsilicium.scripture.shared.model

import com.exsilicium.scripture.shared.model.Book.*
import org.junit.jupiter.api.Assertions.assertTrue
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
}
