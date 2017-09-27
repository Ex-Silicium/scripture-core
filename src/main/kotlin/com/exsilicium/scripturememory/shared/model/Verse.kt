package com.exsilicium.scripturememory.shared.model

data class Verse(
        val chapter: Int,
        val number: Int,
        val part: Char? = null
) : Comparable<Verse> {
    override fun compareTo(other: Verse): Int {
        return chapter.compareTo(other.chapter).let {
            if (it != 0) it else number.compareTo(other.number).let {
                when {
                    it != 0 -> it
                    part == null -> if (other.part == null) 0 else -1
                    else -> if (other.part == null) 1 else part.compareTo(other.part)
                }
            }
        }
    }

    operator fun minus(other: Verse): Int {
        if (chapter == other.chapter) {
            return number - other.number
        } else {
            throw UnsupportedOperationException("Cannot subtract verse with different chapter")
        }
    }
}
