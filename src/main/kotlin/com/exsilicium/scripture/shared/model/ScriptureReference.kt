package com.exsilicium.scripture.shared.model

/**
 * A discrete reference to a [Book] and optional [Location] in scripture.
 */
data class ScriptureReference(
        val book: Book,
        val location: Location? = null
) : Comparable<ScriptureReference> {

    /**
     * A single chapter in a given Book.
     */
    constructor(
            book: Book,
            chapter: Int
    ) : this(book, ChapterRanges(ChapterRange(chapter)))

    /**
     * A single verse in a given Book.
     */
    constructor(
            book: Book,
            verse: Verse
    ) : this(book, VerseRanges(VerseRange(verse)))

    init {
        require(location?.isValid(book) ?: true)
    }

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
