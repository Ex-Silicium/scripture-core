package com.exsilicium.scripture.shared.model

import com.exsilicium.scripture.shared.extensions.compareChapterRanges
import com.exsilicium.scripture.shared.extensions.compareVerseRanges
import java.util.SortedSet

sealed class Location : Comparable<Location>

data class ChapterRanges(
        val chapterRanges: SortedSet<ClosedRange<Int>>
) : Location() {
    constructor(vararg ranges: ClosedRange<Int>) : this(ranges.toSortedSet(ChapterRangeComparator()))

    init {
        require(chapterRanges.isNotEmpty())
    }

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
}

data class VerseRanges(
        val verseRanges: SortedSet<ClosedRange<Verse>>
) : Location() {
    constructor(vararg ranges: ClosedRange<Verse>) : this(ranges.toSortedSet(VerseRangeComparator()))

    init {
        require(verseRanges.isNotEmpty())
    }

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
}
