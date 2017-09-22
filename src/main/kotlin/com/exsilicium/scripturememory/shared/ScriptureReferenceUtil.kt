package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.BibleBook
import com.exsilicium.scripturememory.shared.model.ScriptureReference
import com.exsilicium.scripturememory.shared.model.Verse
import com.exsilicium.scripturememory.shared.model.VerseRange
import java.security.InvalidParameterException
import kotlin.text.RegexOption.IGNORE_CASE

class ScriptureReferenceUtil private constructor() {
    companion object {

        // TODO parse multiple references

        fun parse(input: String): ScriptureReference {
            require(input.isNotEmpty())
            val reference = input.trim()
            if (reference.contains(':')) {
                val referenceParts = reference.split(':')
                val endIndex = referenceParts[0].lastIndexOf(' ')
                val book = referenceParts[0].substring(0, endIndex)
                val chapter = referenceParts[0].substring(endIndex).trim()
                return ScriptureReference(
                        BibleBook.parse(book),
                        chapter.toInt(),
                        parseVerseRanges(referenceParts[1])
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

        private fun parseVerseRanges(verseRangesString: String) = when {
            verseRangesString.contains(',') -> verseRangesString.split(',').map { parseVerseRange(it) }
            else -> listOf(parseVerseRange(verseRangesString))
        }

        private fun parseVerseRange(verseRangeString: String) = when {
            verseRangeString.contains('-') -> {
                verseRangeString.split('-').let {
                    parseVerse(it[0])..parseVerse(it[1])
                }
            }
            else -> VerseRange(parseVerse(verseRangeString))
        }

        private fun parseVerse(verseString: String) = when {
            verseString.contains(Regex("[a-c]", IGNORE_CASE)) -> {
                verseString.forEachIndexed { i, char ->
                    if (char.isLetter()) {
                        return Verse(verseString.substring(0, i).trim().toInt(), char.toLowerCase())
                    }
                }
                throw InvalidParameterException("Failed to parse verse")
            }
            else -> Verse(verseString.trim().toInt())
        }
    }
}