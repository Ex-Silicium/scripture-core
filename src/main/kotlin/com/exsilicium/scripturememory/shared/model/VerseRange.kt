package com.exsilicium.scripturememory.shared.model

data class VerseRange(
        val start: Verse,
        val end: Verse = start
) {
    init {
        require(start <= end)
    }
}
