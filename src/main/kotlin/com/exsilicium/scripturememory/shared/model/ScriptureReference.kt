package com.exsilicium.scripturememory.shared.model

data class ScriptureReference(
        // todo consider hierarchy: Book, or Book and Chapter(s), or Book and ch.(s) and verse(s)
        val book: Book,
        val chapter: Int, // todo permit chapter ranges like 2:9-3:2
        val verseRanges: List<ClosedRange<Verse>> = listOf()
) {
    constructor(
            book: Book,
            chapter: Int,
            verseRange: ClosedRange<Verse>
    ) : this(book, chapter, listOf(verseRange))

    constructor(
            book: Book,
            chapter: Int,
            verse: Verse
    ) : this(book, chapter, listOf(VerseRange(verse)))
}
