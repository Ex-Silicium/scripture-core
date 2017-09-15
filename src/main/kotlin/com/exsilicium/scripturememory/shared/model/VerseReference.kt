package com.exsilicium.scripturememory.shared.model

data class VerseReference(
        val book: BibleBook,
        val chapter: Int?,
        val verseRanges: List<VerseRange>
)
