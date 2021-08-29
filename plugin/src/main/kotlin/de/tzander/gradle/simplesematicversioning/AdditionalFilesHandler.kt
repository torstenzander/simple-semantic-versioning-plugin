package de.tzander.gradle.simplesematicversioning

import java.io.File

class AdditionalFilesHandler constructor(semanticVersion: SemanticVersion) {

    var semanticVersion: SemanticVersion = semanticVersion

    fun replaceInFiles(rootDir: String, files: List<String>?, prefixes: List<String>? ) {
        var i = 0
        files?.forEach {
            val file = File("$rootDir/$it")
            var text = file.readText()
            var prefix = prefixes?.get(i)
            text = text.replace(prefix + semanticVersion.oldVersion, prefix + semanticVersion.newVersion())
            file.writeText(text)
            println("File updated: $it")
            i++
        }
    }
}