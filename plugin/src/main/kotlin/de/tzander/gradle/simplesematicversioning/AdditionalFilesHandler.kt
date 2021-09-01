package de.tzander.gradle.simplesematicversioning

import java.io.File

class AdditionalFilesHandler constructor(private var semanticVersion: SemanticVersion) {

    private var prefix: String = ""

    fun replaceInFiles(rootDir: String, files: List<String>? = listOf(), prefixes: List<String>? = listOf()) {
        var i = 0
        files?.forEach {
            val file = File("$rootDir/$it")
            var text = file.readText()
            if (!prefixes?.get(i).isNullOrBlank()) {
                prefix = prefixes?.get(i).toString()
            }
            val newVersion = semanticVersion.newVersion()
            text = text.replace(prefix + semanticVersion.originalVersionString, prefix + newVersion)
            file.writeText(text)
            println("The file $it was updated to $newVersion")
            i++
        }
    }
}