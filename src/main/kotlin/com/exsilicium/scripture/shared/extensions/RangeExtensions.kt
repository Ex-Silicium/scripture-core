package com.exsilicium.scripture.shared.extensions

internal fun <T : Comparable<T>> ClosedRange<out T>.isEmptyRange() = start >= endInclusive