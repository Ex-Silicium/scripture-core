package com.exsilicium.scripturememory.shared.model

data class ChapterRange(
        override val start: Int,
        override val endInclusive: Int = start
) : ClosedRange<Int> {
    init {
        require(start <= endInclusive)
    }
}

internal class ChapterRangeComparator : Comparator<ClosedRange<Int>> {
    override fun compare(first: ClosedRange<Int>, second: ClosedRange<Int>) = first.start.compareTo(second.start)
}
