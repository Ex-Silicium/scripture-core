package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange
import com.exsilicium.scripturememory.shared.model.VerseReference

class VerseReferenceUtil private constructor() {
    companion object {
        fun parse(reference: String): VerseReference {
            val referenceParts = reference.split(" ")
            val numberParts = referenceParts[1].split(":")
            return VerseReference(
                    BibleBook.parse(referenceParts[0]),
                    numberParts[0].toInt(),
                    parseVerseRanges(numberParts[1])
            )
        }

        private fun parseVerseRanges(verseRangesString: String): List<VerseRange> {
            return listOf(VerseRange(Verse(verseRangesString.toInt())))
        }
    }
}