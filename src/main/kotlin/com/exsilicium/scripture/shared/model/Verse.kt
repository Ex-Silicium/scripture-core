package com.exsilicium.scripture.shared.model

/**
 * A verse with a chapter, number, and optional part letter (i.e. 'a', 'b', 'c', or 'd').
 */
data class Verse(
        val chapter: Int,
        val verseNumber: Int,
        val part: Char? = null
) : Comparable<Verse> {
    init {
        require(chapter >= 0)
        require(verseNumber >= 0)
        require(part == null || part in MIN_PART_CHAR..MAX_PART_CHAR)
    }

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

    override fun toString(): String {
        val chapterAndVerse = "$chapter:$verseNumber"
        return if (part == null) chapterAndVerse else "$chapterAndVerse$part"
    }

    internal operator fun minus(other: Verse): Int {
        if (chapter == other.chapter) {
            return verseNumber - other.verseNumber
        }
        throw UnsupportedOperationException("Cannot subtract verse with different chapter")
    }

    companion object {
        internal const val MIN_PART_CHAR = 'a'
        internal const val MAX_PART_CHAR = 'd'
    }
}
