package de.tzander.gradle.simplesematicversioning

import org.gradle.api.Project
import java.io.File
import java.util.*

class PropertyFileHandler constructor(private val project: Project) {

    private var properties: Properties = Properties()

    private lateinit var propertyFile: File

    fun readVersionFromFile(): String {
        val projectDir = project.getProperties().get("projectDir")
        propertyFile = File(projectDir.toString() + "/gradle.properties")
        properties.load(propertyFile.inputStream())
        return properties.getProperty("version")
    }

    fun savePropertyToFile(newVersion: String) {
        properties.setProperty("version", newVersion)
        properties.store(propertyFile.writer(), null)
        properties.load(propertyFile.inputStream())
    }
}