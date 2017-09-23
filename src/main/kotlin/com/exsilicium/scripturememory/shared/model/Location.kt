package com.exsilicium.scripturememory.shared.model

sealed class Location

data class ChapterRanges(
        val chapterRanges: Set<ClosedRange<Int>>
) : Location()

data class VerseRanges(
        val verseRanges: Set<ClosedRange<Verse>>
) : Location()
