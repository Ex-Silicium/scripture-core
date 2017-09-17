package com.exsilicium.scripturememory.shared.model

data class ScriptureReference(
        val book: BibleBook,
        val chapter: Int? = null,
        val verseRanges: List<VerseRange> = listOf()
)
