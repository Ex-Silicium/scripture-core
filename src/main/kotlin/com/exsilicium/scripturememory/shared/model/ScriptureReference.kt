package com.exsilicium.scripturememory.shared.model

data class ScriptureReference(
        val book: Book,
        val location: Location? = null
) : Comparable<ScriptureReference> {
    constructor(
            book: Book,
            chapter: Int
    ) : this(book, ChapterRanges(ChapterRange(chapter)))

    constructor(
            book: Book,
            verse: Verse
    ) : this(book, VerseRanges(VerseRange(verse)))

    override fun compareTo(other: ScriptureReference) = book.compareTo(other.book).let {
        when {
            it != 0 -> it
            location == null -> when {
                other.location == null -> 0
                else -> -1
            }
            else -> when {
                other.location == null -> 1
                else -> location.compareTo(other.location)
            }
        }
    }
}
