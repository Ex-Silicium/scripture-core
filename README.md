# Scripture Core

[![Download](https://api.bintray.com/packages/ex-silicium/scripture/scripture-core/images/download.svg)][1]
[![CircleCI](https://circleci.com/gh/Ex-Silicium/scripture-core.svg?style=svg)](https://circleci.com/gh/Ex-Silicium/scripture-core)

Scripture Core provides tools for working with scripture references. It provides the `ScriptureReference` class to model different types of scripture references (e.g. an entire book, chapter(s), ranges of chapters, verse(s), and ranges of verses).

A `ScriptureReference` can be parsed from a `String` using the `ScriptureReferenceUtil` class.

## Example Usage

Parse a `ScriptureReference` from a `String`:

A `ScriptureReference` can be just a `Book`:
```kotlin
ScriptureReferenceUtil.parse("Romans")
```

The `Book` can be parsed from an abbreviation:
```kotlin
ScriptureReferenceUtil.parse("Ro")
```

It can be a `Book` and a chapter:
```kotlin
ScriptureReferenceUtil.parse("Romans 8")
```

It can be a `Book`, a chapter, and a verse:
```kotlin
ScriptureReferenceUtil.parse("Romans 8:1")
```

It can be a `Book`, a chapter, and a range of verses:
```kotlin
ScriptureReferenceUtil.parse("Romans 8:1-3")
```

It can be a `Book`, a chapter, and a set of ranges of verses:
```kotlin
ScriptureReferenceUtil.parse("Romans 8:1-3, 4-5")
```

It can be a `Book` and a set of ranges of chapters:
```kotlin
ScriptureReferenceUtil.parse("Romans 8-9, 11")
```

It can be a `Book` and a set of ranges of chapter with verse:
```kotlin
ScriptureReferenceUtil.parse("Romans 8:1-9:2")
```

It can be a `Book` and multiple combinations of above within same book separated by `;`:
```kotlin
ScriptureReferenceUtil.parse("Romans 8:1-3; 9:1,2; 10")
```

## Download

Download [the latest JAR][1] or grab via jCenter:
```groovy
compile 'com.exsilicium.scripture:scripture-core:0.1.2'
```

[1]: https://bintray.com/ex-silicium/scripture/scripture-core/_latestVersion
