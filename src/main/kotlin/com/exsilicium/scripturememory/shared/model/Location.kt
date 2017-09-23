package com.exsilicium.scripturememory.shared.model

sealed class Location : Comparable<Location>

data class ChapterRanges(
        val chapterRanges: Set<ClosedRange<Int>>
) : Location() {
    override fun compareTo(other: Location): Int {
        if (other is VerseRanges) {
            return chapterRanges.first().start.compareTo(other.verseRanges.first().start.chapter)
        } else if (other is ChapterRanges) {
            return chapterRanges.first().start.compareTo(other.chapterRanges.first().start)
        }
        throw IllegalStateException("Failed to compare chapter ranges")
    }
}

data class VerseRanges(
        val verseRanges: Set<ClosedRange<Verse>>
) : Location() {
    override fun compareTo(other: Location): Int {
        if (other is ChapterRanges) {
            return verseRanges.first().start.chapter.compareTo(other.chapterRanges.first().start)
        } else if (other is VerseRanges) {
            return verseRanges.first().start.compareTo(other.verseRanges.first().start)
        }
        throw IllegalStateException("Failed to compare verse ranges")
    }
}
