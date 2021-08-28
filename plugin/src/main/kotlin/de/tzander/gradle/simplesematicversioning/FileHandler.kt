package de.tzander.gradle.simplesematicversioning

import java.io.File

class FileHandler  {

    fun replaceInFiles(rootDir: String, files: List<String>?, oldVersion: String, semanticVersion: SemanticVersion) {
        files?.forEach {
            val file = File("$rootDir/$it")
            var text = file.readText()
            text = text.replace(oldVersion, semanticVersion.toString())
            file.writeText(text)
            println("File updated: $it")
        }
    }
}