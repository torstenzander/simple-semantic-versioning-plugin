package de.tzander.gradle.simplesematicversioning

abstract class SimpleSemanticVersioningExtension {
    var files: List<String>? = null
    var prefixes: List<String>? = null
}