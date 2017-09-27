package com.exsilicium.scripturememory.shared.model

data class Verse(
        val chapter: Int,
        val verseNumber: Int,
        val part: Char? = null
) : Comparable<Verse> {
    init {
        require(chapter >= 0)
        require(verseNumber >= 0)
        require(part in arrayOf(null, 'a', 'b', 'c', 'd'))
    }

    fun isValid(book: Book) = book.chapterCount >= chapter && book.versesInChapter(chapter) >= verseNumber

    override fun compareTo(other: Verse): Int {
        return chapter.compareTo(other.chapter).let {
            if (it != 0) it else verseNumber.compareTo(other.verseNumber).let {
                when {
                    it != 0 -> it
                    part == null -> if (other.part == null) 0 else -1
                    else -> if (other.part == null) 1 else part.compareTo(other.part)
                }
            }
        }
    }

    operator fun minus(other: Verse): Int {
        if (chapter == other.chapter) {
            return verseNumber - other.verseNumber
        }
        throw UnsupportedOperationException("Cannot subtract verse with different chapter")
    }
}
