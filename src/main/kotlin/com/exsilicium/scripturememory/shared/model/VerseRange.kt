package com.exsilicium.scripturememory.shared.model

data class VerseRange(
        override val start: Verse,
        override val endInclusive: Verse = start
) : ClosedRange<Verse> {
    init {
        require(start <= endInclusive)
    }
}
