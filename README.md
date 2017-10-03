# scripture-core

[ ![Download](https://api.bintray.com/packages/ex-silicium/scripture/scripture-core/images/download.svg) ](https://bintray.com/ex-silicium/scripture/scripture-core/_latestVersion)
[![CircleCI](https://circleci.com/gh/Ex-Silicium/scripture-core.svg?style=svg)](https://circleci.com/gh/Ex-Silicium/scripture-core)

Tools for working with scripture references.

## Download

Download [the latest JAR][1] or grab via jCenter:
```groovy
compile 'com.exsilicium.scripture:scripture-core:0.1.0'
```

## Example Usage

Parse a `ScriptureReference` from a `String`:

A `ScriptureReference` can be just a `Book`:
```kotlin
ScriptureReferenceUtil.parse("Romans")
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

[1]: https://bintray.com/ex-silicium/scripture/scripture-core/_latestVersion
