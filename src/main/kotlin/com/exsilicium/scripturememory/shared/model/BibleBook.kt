package com.exsilicium.scripturememory.shared.model

enum class BibleBook(
        val title: String,
        val abbreviations: List<String>
) {
    GENESIS("Genesis",
            listOf("Gen", "Ge", "Gn")
    ),
    EXODUS("Exodus",
            listOf("Exo", "Ex", "Exod")
    ),
    LEVITICUS("Leviticus",
            listOf("Lev", "Le", "Lv")
    ),
    NUMBERS("Numbers",
            listOf("Num", "Nu", "Nm", "Nb")
    ),
    DEUTERONOMY("Deuteronomy",
            listOf("Deut", "Dt")
    ),
    JOSHUA("Joshua",
            listOf("Josh", "Jos", "Jsh")
    ),
    JUDGES("Judges",
            listOf("Judg", "Jdg", "Jg", "Jdgs")
    ),
    RUTH("Ruth",
            listOf("Rth", "Ru")
    ),
    FIRST_SAMUEL("1 Samuel",
            listOf("1 Sam", "1 Sa", "1Samuel", "1S", "I Sa", "1 Sm", "1Sa", "I Sam", "1Sam", "I Samuel", "1st Samuel",
                    "First Samuel")
    ),
    SECOND_SAMUEL("2 Samuel",
            listOf("2 Sam", "2 Sa", "2S", "II Sa", "2 Sm", "2Sa", "II Sam", "2Sam", "II Samuel", "2Samuel",
                    "2nd Samuel", "Second Samuel")
    ),
    FIRST_KINGS("1 Kings",
            listOf("1 Kgs", "1 Ki", "1K", "I Kgs", "1Kgs", "I Ki", "1Ki", "I Kings", "1Kings", "1st Kgs", "1st Kings",
                    "First Kings", "First Kgs", "1Kin")
    ),
    SECOND_KINGS("2 Kings",
            listOf("2 Kgs", "2 Ki", "2K", "II Kgs", "2Kgs", "II Ki", "2Ki", "II Kings", "2Kings", "2nd Kgs",
                    "2nd Kings", "Second Kings", "Second Kgs", "2Kin")
    ),
    FIRST_CHRONICLES("1 Chronicles",
            listOf("1 Chron", "1 Ch", "I Ch", "1Ch", "1 Chr", "I Chr", "1Chr", "I Chron", "1Chron", "I Chronicles",
                    "1Chronicles", "1st Chronicles", "First Chronicles")
    ),
    SECOND_CHRONICLES("2 Chronicles",
            listOf("2 Chron", "2 Ch", "II Ch", "2Ch", "II Chr", "2Chr", "II Chron", "2Chron", "II Chronicles",
                    "2Chronicles", "2nd Chronicles", "Second Chronicles")
    ),
    EZRA("Ezra",
            listOf("Ezr")
    ),
    NEHEMIAH("Nehemiah",
            listOf("Neh", "Ne")
    ),
    ESTHER("Esther",
            listOf("Esth", "Es")
    ),
    JOB("Job",
            listOf("Jb")
    ),
    PSALMS("Psalms",
            listOf("Pslm", "Ps", "Psa", "Psm", "Pss")
    ),
    PROVERBS("Proverbs",
            listOf("Prov", "Pr", "Prv")
    ),
    ECCLESIASTES("Ecclesiastes",
            listOf("Eccles", "Ec", "Ecc", "Qoh", "Qoheleth")
    ),
    SONG_OF_SOLOMON("Song of Solomon",
            listOf("Song", "So", "Canticle of Canticles", "Canticles", "Song of Songs", "SOS")
    ),
    ISAIAH("Isaiah",
            listOf("Isa", "Is")
    ),
    JEREMIAH("Jeremiah",
            listOf("Jer", "Je", "Jr")
    ),
    LAMENTATIONS("Lamentations",
            listOf("Lam", "La")
    ),
    EZEKIEL("Ezekiel",
            listOf("Ezek", "Eze", "Ezk")
    ),
    DANIEL("Daniel",
            listOf("Dan", "Da", "Dn")
    ),
    HOSEA("Hosea",
            listOf("Hos", "Ho")
    ),
    JOEL("Joel",
            listOf("Joe", "Jl")
    ),
    AMOS("Amos",
            listOf("Am")
    ),
    OBADIAH("Obadiah",
            listOf("Obad", "Ob")
    ),
    JONAH("Jonah",
            listOf("Jnh", "Jon")
    ),
    MICAH("Micah",
            listOf("Mic")
    ),
    NAHUM("Nahum",
            listOf("Nah", "Na")
    ),
    HABAKKUK("Habakkuk",
            listOf("Hab")
    ),
    ZEPHANIAH("Zephaniah",
            listOf("Zeph", "Zep", "Zp")
    ),
    HAGGAI("Haggai",
            listOf("Hag", "Hg")
    ),
    ZECHARIAH("Zechariah",
            listOf("Zech", "Zec", "Zc")
    ),
    MALACHI("Malachi",
            listOf("Mal", "Ml")
    ),
    // New Testament
    MATTHEW("Matthew",
            listOf("Matt", "Mt")
    ),
    MARK("Mark",
            listOf("Mrk", "Mk", "Mr")
    ),
    LUKE("Luke",
            listOf("Luk", "Lk")
    ),
    JOHN("John",
            listOf("Jn", "Jhn")
    ),
    ACTS("Acts",
            listOf("Ac")
    ),
    ROMANS("Romans",
            listOf("Rom", "Ro", "Rm")
    ),
    FIRST_CORINTHIANS("1 Corinthians",
            listOf("1 Cor", "1 Co", "I Co", "1Co", "I Cor", "1Cor", "I Corinthians", "1Corinthians", "1st Corinthians",
                    "First Corinthians")
    ),
    SECOND_CORINTHIANS("2 Corinthians",
            listOf("2 Cor", "2 Co", "II Co", "2Co", "II Cor", "2Cor", "II Corinthians", "2Corinthians",
                    "2nd Corinthians", "Second Corinthians")
    ),
    GALATIANS("Galatians",
            listOf("Gal", "Ga")
    ),
    EPHESIANS("Ephesians",
            listOf("Ephes", "Eph")
    ),
    PHILIPPIANS("Philippians",
            listOf("Phil", "Php")
    ),
    COLOSSIANS("Colossians",
            listOf("Col")
    ),
    FIRST_THESSALONIANS("1 Thessalonians",
            listOf("1 Thess", "1 Th", "I Th", "1Th", "I Thes", "1Thes", "I Thess", "1Thess", "I Thessalonians",
                    "1Thessalonians", "1st Thessalonians", "First Thessalonians")
    ),
    SECOND_THESSALONIANS("2 Thessalonians",
            listOf("2 Thess", "2 Th", "II Th", "2Th", "II Thes", "2Thes", "II Thess", "2Thess", "II Thessalonians",
                    "2Thessalonians", "2nd Thessalonians", "Second Thessalonians")
    ),
    FIRST_TIMOTHY("1 Timothy",
            listOf("1 Tim", "1 Ti", "I Ti", "1Ti", "I Tim", "1Tim", "I Timothy", "1Timothy", "1st Timothy",
                    "First Timothy")
    ),
    SECOND_TIMOTHY("2 Timothy",
            listOf("2 Tim", "2 Ti", "II Ti", "2Ti", "II Tim", "2Tim", "II Timothy", "2Timothy", "2nd Timothy",
                    "Second Timothy")
    ),
    TITUS("Titus",
            listOf("Tit")
    ),
    PHILEMON("Philemon",
            listOf("Philem", "Phm")
    ),
    HEBREWS("Hebrews",
            listOf("Heb")
    ),
    JAMES("James",
            listOf("Jas", "Jm")
    ),
    FIRST_PETER("1 Peter",
            listOf("1 Pet", "1 Pe", "I Pe", "1Pe", "I Pet", "1Pet", "I Pt", "1 Pt", "1Pt", "I Peter", "1Peter",
                    "1st Peter", "First Peter")
    ),
    SECOND_PETER("2 Peter",
            listOf("2 Pet", "2 Pe", "II Pe", "2Pe", "II Pet", "2Pet", "II Pt", "2 Pt", "2Pt", "II Peter", "2Peter",
                    "2nd Peter", "Second Peter")
    ),
    FIRST_JOHN("1 John",
            listOf("1 John", "1 Jn", "I Jn", "1Jn", "I Jo", "1Jo", "I Joh", "1Joh", "I Jhn", "1 Jhn", "1Jhn", "I John",
                    "1John", "1st John", "First John")
    ),
    SECOND_JOHN("2 John",
            listOf("2 John", "2 Jn", "II Jn", "2Jn", "II Jo", "2Jo", "II Joh", "2Joh", "II Jhn", "2 Jhn", "2Jhn",
                    "II John", "2John", "2nd John", "Second John")
    ),
    THIRD_JOHN("3 John",
            listOf("3 John", "3 Jn", "III Jn", "3Jn", "III Jo", "3Jo", "III Joh", "3Joh", "III Jhn", "3 Jhn", "3Jhn",
                    "III John", "3John", "3rd John", "Third John")
    ),
    JUDE("Jude",
            listOf("Jud")
    ),
    REVELATION("Revelation",
            listOf("Rev", "Re", "The Revelation")
    );

    companion object {
        fun parse(name: String) = name.trim().toLowerCase().let { lowercaseName ->
            findBookNameMatch(lowercaseName) ?: findBookAbbreviationMatch(lowercaseName) ?:
                    throw IllegalStateException("Could not parse book name")
        }

        private fun findBookNameMatch(lowercaseName: String)
                = values().firstOrNull { lowercaseName == it.title.toLowerCase() }

        private fun findBookAbbreviationMatch(lowercaseName: String)
                = values().firstOrNull { it.abbreviations.map { it.toLowerCase() }.contains(lowercaseName) }
    }
}
