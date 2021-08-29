package de.tzander.gradle.simplesematicversioning

import java.io.File

class AdditionalFilesHandler constructor(var semanticVersion: SemanticVersion) {

    var prefix: String = ""

    fun replaceInFiles(rootDir: String, files: List<String>? = listOf(), prefixes: List<String>? = listOf()) {
        var i = 0
        files?.forEach {
            val file = File("$rootDir/$it")
            var text = file.readText()
            if (!prefixes?.get(i).isNullOrBlank()) {
                prefix = prefixes?.get(i).toString()
            }
            val newVersionWithPrefix = prefix + semanticVersion.newVersion()
            text = text.replace(prefix + semanticVersion.oldVersion, newVersionWithPrefix)
            file.writeText(text)
            println("File updated: $it to $newVersionWithPrefix")
            i++
        }
    }
}