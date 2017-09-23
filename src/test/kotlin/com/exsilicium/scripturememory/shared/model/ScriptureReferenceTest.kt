package com.exsilicium.scripturememory.shared.model

import com.exsilicium.scripturememory.shared.model.Book.JOHN
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ScriptureReferenceTest {
    @Test fun `Chapter 1 before chapter 2`() {
        Assertions.assertTrue(ScriptureReference(JOHN, 1) < ScriptureReference(JOHN, 2))
    }
}
