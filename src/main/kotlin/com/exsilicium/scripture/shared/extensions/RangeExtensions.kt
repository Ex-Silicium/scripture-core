package com.exsilicium.scripture.shared.extensions

import com.exsilicium.scripture.shared.model.Verse

internal fun <T : Comparable<T>> ClosedRange<out T>.isEmptyRange() = start >= endInclusive

internal fun ClosedRange<Verse>.rangeHasSameChapter() = start.chapter == endInclusive.chapter