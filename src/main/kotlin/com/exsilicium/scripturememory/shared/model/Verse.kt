package com.exsilicium.scripturememory.shared.model

data class Verse(
        val chapter: Int,
        val number: Int,
        val part: Char? = null
) : Comparable<Verse> {
    override fun compareTo(other: Verse) = chapter.compareTo(other.chapter).let {
        when {
            it != 0 -> it
            else -> number.compareTo(other.number).let {
                when {
                    it != 0 -> it
                    part == null -> when {
                        other.part == null -> 0
                        else -> -1
                    }
                    else -> when {
                        other.part == null -> 1
                        else -> part.compareTo(other.part)
                    }
                }
            }
        }
    }
}
