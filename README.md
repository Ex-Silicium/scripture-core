# scripture-core

[![CircleCI](https://circleci.com/gh/Ex-Silicium/scripture-core.svg?style=svg)](https://circleci.com/gh/Ex-Silicium/scripture-core)

Tools for working with scripture references.

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
