package com.exsilicium.scripturememory.shared

import com.exsilicium.scripturememory.shared.model.*
import java.security.InvalidParameterException
import kotlin.text.RegexOption.IGNORE_CASE

class ScriptureReferenceUtil private constructor() {
    companion object {
        fun parse(input: String): ScriptureReference {
            require(input.isNotEmpty())
            val reference = input.trim()
            if (reference.contains(':')) {
                val referenceParts = reference.split(':')
                val endIndex = referenceParts[0].lastIndexOf(' ')
                val book = referenceParts[0].substring(0, endIndex)
                val chapter = referenceParts[0].substring(endIndex).trim()
                return ScriptureReference(
                        Book.parse(book),
                        VerseRanges(parseVerseRanges(chapter.toInt(), referenceParts[1]))
                )
            } else {
                if (reference.contains(Regex("[1-9]"))) {
                    reference.forEachIndexed({ i, char ->
                        if (char.isDigit() and (i > 0)) {
                            val book = Book.parse(reference.substring(0, i))
                            return ScriptureReference(book, parseChapterRanges(reference.substring(i)))
                        }
                    })
                }
                return ScriptureReference(Book.parse(reference))
            }
        }

        private fun parseChapterRanges(chapters: String) = when {
            chapters.contains(',') -> ChapterRanges(chapters.split(",").map { parseChapterRange(it) }
                    .toSortedSet(ChapterRangeComparator()))
            else -> ChapterRanges(parseChapterRange(chapters))
        }

        private fun parseChapterRange(chapterRangeString: String) = when {
            chapterRangeString.contains('-') -> chapterRangeString.split('-').let {
                it[0].trim().toInt()..it[1].trim().toInt()
            }
            else -> ChapterRange(chapterRangeString.trim().toInt())
        }

        private fun parseVerseRanges(chapter: Int, verseRangesString: String) = when {
            verseRangesString.contains(',') -> verseRangesString.split(',').map { parseVerseRange(chapter, it) }
                    .toSortedSet(VerseRangeComparator())
            else -> sortedSetOf(VerseRangeComparator(), parseVerseRange(chapter, verseRangesString))
        }

        private fun parseVerseRange(chapter: Int, verseRangeString: String) = when {
            verseRangeString.contains('-') -> {
                verseRangeString.split('-').let {
                    parseVerse(chapter, it[0])..parseVerse(chapter, it[1])
                }
            }
            else -> VerseRange(parseVerse(chapter, verseRangeString))
        }

        private fun parseVerse(chapter: Int, verseString: String) = when {
            verseString.contains(Regex("[a-c]", IGNORE_CASE)) -> {
                verseString.forEachIndexed { i, char ->
                    if (char.isLetter()) {
                        return Verse(chapter, verseString.substring(0, i).trim().toInt(), char.toLowerCase())
                    }
                }
                throw InvalidParameterException("Failed to parse verse")
            }
            else -> Verse(chapter, verseString.trim().toInt())
        }
    }
}