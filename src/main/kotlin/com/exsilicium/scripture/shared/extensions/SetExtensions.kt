package com.exsilicium.scripture.shared.extensions

internal fun <T : ClosedRange<U>, U : Comparable<U>> Set<T>.createJoinedString()
        = joinToString { if (it.isEmptyRange()) "${it.start}" else "${it.start}-${it.endInclusive}" }