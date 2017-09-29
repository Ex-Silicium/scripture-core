package com.exsilicium.scripture.shared.model

data class VerseRange(
        override val start: Verse,
        override val endInclusive: Verse = start
) : ClosedRange<Verse> {
    init {
        require(start <= endInclusive)
    }
}

internal class VerseRangeComparator : Comparator<ClosedRange<Verse>> {
    override fun compare(first: ClosedRange<Verse>, second: ClosedRange<Verse>) = first.start.compareTo(second.start)
}
