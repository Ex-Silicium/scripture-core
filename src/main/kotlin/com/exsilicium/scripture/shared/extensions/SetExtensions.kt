package com.exsilicium.scripture.shared.extensions

import com.exsilicium.scripture.shared.model.Verse

internal fun <T : ClosedRange<U>, U : Comparable<U>> Set<T>.createJoinedString()
        = joinToString { if (it.isEmptyRange()) "${it.start}" else "${it.start}-${it.endInclusive}" }

internal fun Set<ClosedRange<Verse>>.joinString(): String {
    return joinToString {
        if (it.isEmptyRange()) {
            "${it.start}"
        } else {
            if (it.rangeHasSameChapter()) {
                "${it.start}-${it.endInclusive.verseNumberAndPart()}"
            } else {
                "${it.start}-${it.endInclusive}"
            }
        }
    }
}