package de.tzander.gradle.simplesematicversioning

import org.gradle.api.Project
import java.io.File
import java.util.*

class PropertyFileHandler constructor(private val project: Project) {
    private lateinit var properties: Properties
    private lateinit var propertyFile: File

    fun readVersionFromFile(): String {
        val projectDir = project.getProperties().get("projectDir")
        properties = Properties()
        propertyFile = File(projectDir.toString() + "/version.gradle")
        properties.load(propertyFile.inputStream())
        return properties.getProperty("version")
    }

    fun savePropertyToFile(newVersion: String) {
        properties.setProperty("version", newVersion)
        properties.store(propertyFile.writer(), null)
        properties.load(propertyFile.inputStream())
    }
}