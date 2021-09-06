package de.tzander.gradle.simplesemanticversioning

abstract class SimpleSemanticVersioningExtension {
    var files: List<String>? = null
    var prefixes: List<String>? = null
}