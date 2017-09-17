package com.exsilicium.scripturememory.shared.model

data class ScriptureReference(
        val book: BibleBook,
        val chapter: Int? = null,
        val verseRanges: List<ClosedRange<Verse>> = listOf()
) {
    constructor(
            book: BibleBook,
            chapter: Int,
            verseRange: ClosedRange<Verse>
    ) : this(book, chapter, listOf(verseRange))

    constructor(
            book: BibleBook,
            chapter: Int,
            verse: Verse
    ) : this(book, chapter, listOf(VerseRange(verse)))
}
