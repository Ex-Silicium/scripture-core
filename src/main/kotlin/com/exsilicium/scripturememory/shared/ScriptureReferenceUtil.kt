package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook
import com.exsilicium.scripturememory.shared.model.ScriptureReference
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange

class ScriptureReferenceUtil private constructor() {
    companion object {
        fun parse(input: String): ScriptureReference {
            require(input.isNotEmpty())
            val reference = input.trim()
            if (reference.contains(':')) {
                val referenceParts = reference.split(' ')
                val numberParts = referenceParts[1].split(':')
                return ScriptureReference(
                        BibleBook.parse(referenceParts[0]),
                        numberParts[0].toInt(),
                        parseVerseRanges(numberParts[1])
                )
            } else {
                if (reference.contains(Regex("[1-9]"))) {
                    reference.forEachIndexed({ i, char ->
                        if (char.isDigit() and (i > 0)) {
                            val book = BibleBook.parse(reference.substring(0, i))
                            return ScriptureReference(book, reference.substring(i).toInt())
                        }
                    })
                }
                return ScriptureReference(BibleBook.parse(reference))
            }
        }

        private fun parseVerseRanges(verseRangesString: String): List<VerseRange> {
            return listOf(VerseRange(Verse(verseRangesString.toInt())))
        }
    }
}