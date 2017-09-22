package com.exsilicium.scripturememory.shared.model

data class ScriptureReference(
        // todo consider hierarchy: Book, or Book and Chapter(s), or Book and ch.(s) and verse(s)
        val book: Book,
        val chapter: Int? = null, // todo permit chapter ranges like 2:9-3:2
        val verseRanges: List<ClosedRange<Verse>> = listOf()
): Comparable<ScriptureReference> {
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

    override fun compareTo(other: ScriptureReference): Int {
        return book.compareTo(other.book).let {
            when {
                it != 0 -> it
                chapter == null -> when {
                    other.chapter == null -> 0
                    else -> -1 // todo test this part
                }
                else -> when {
                    other.chapter == null -> 1
                    else -> chapter.compareTo(other.chapter).let {
                        when {
                            it != 0 -> it // todo fix below
                            else -> verseRanges.compareTo(other.verseRanges)
                        }
                    }
                }
            }
        }
    }
}
