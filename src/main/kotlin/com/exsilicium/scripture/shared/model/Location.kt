package com.exsilicium.scripture.shared.model

import com.exsilicium.scripture.shared.extensions.compareChapterRanges
import com.exsilicium.scripture.shared.extensions.compareVerseRanges
import com.exsilicium.scripture.shared.extensions.createJoinedString
import com.exsilicium.scripture.shared.extensions.isEmptyRange
import java.util.SortedSet

/**
 * A location in a [Book].
 *
 * A [Location] makes no guarantee that it is valid for any [Book].
 */
sealed class Location : Comparable<Location> {
    internal abstract fun isValid(book: Book): Boolean
}

/**
 * A sorted set of inclusive ranges of chapters.
 *
 * E.g. 1-2, 3-5, 7
 */
data class ChapterRanges(
        val chapterRanges: SortedSet<ClosedRange<Int>>
) : Location() {
    constructor(vararg ranges: ClosedRange<Int>) : this(ranges.toSortedSet(ChapterRangeComparator()))

    init {
        require(chapterRanges.isNotEmpty())
        require(chapterRanges.first().start >= 1)
    }

    override fun isValid(book: Book) = chapterRanges.all { book.isValidChapterRange(it) }

    override fun compareTo(other: Location) = when (other) {
        is VerseRanges -> {
            val startComparison = chapterRanges.first().start.compareTo(other.verseRanges.first().start.chapter)
            when (startComparison) {
                0 -> if (other.verseRanges.first().start.verseNumber == 1) 0 else -1
                else -> startComparison
            }
        }
        is ChapterRanges -> compareChapterRanges(other)
    }

    override fun toString() = chapterRanges.createJoinedString()
}

/**
 * A sorted set of inclusive ranges of verses.
 *
 * E.g. 1:1-2:3b, 2:5
 */
data class VerseRanges(
        val verseRanges: SortedSet<ClosedRange<Verse>>
) : Location() {
    constructor(vararg ranges: ClosedRange<Verse>) : this(ranges.toSortedSet(VerseRangeComparator()))

    init {
        require(verseRanges.isNotEmpty())
    }

    override fun isValid(book: Book) = verseRanges.all { book.isValid(it.endInclusive) }

    override fun compareTo(other: Location) = when (other) {
        is ChapterRanges -> {
            val startComparison = verseRanges.first().start.chapter.compareTo(other.chapterRanges.first().start)
            when (startComparison) {
                0 -> if (verseRanges.first().start.verseNumber == 1) 0 else 1
                else -> startComparison
            }
        }
        is VerseRanges -> compareVerseRanges(other)
    }

    override fun toString() = verseRanges.createJoinedString()
}
