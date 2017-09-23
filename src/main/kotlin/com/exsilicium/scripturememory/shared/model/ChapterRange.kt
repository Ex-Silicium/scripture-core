package com.exsilicium.scripturememory.shared.model

data class ChapterRange(
        override val start: Int,
        override val endInclusive: Int = start
) : ClosedRange<Int> {
    init {
        require(start <= endInclusive)
    }
}
