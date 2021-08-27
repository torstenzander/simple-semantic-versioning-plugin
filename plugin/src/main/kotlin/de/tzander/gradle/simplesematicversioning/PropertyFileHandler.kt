package de.tzander.gradle.simplesematicversioning

import org.gradle.api.Project
import java.io.File
import java.util.*

const val PROPERTY_FILE = "/gradle.properties"

class PropertyFileHandler constructor(private val project: Project) {

    private var properties: Properties = Properties()
    private lateinit var propertyFile: File

    fun readVersionFromFile(): String {
        val projectDir = project.properties["projectDir"]
        propertyFile = File(projectDir.toString() + PROPERTY_FILE)
        properties.load(propertyFile.inputStream())
        return properties.getProperty("version")
    }

    fun savePropertyToFile(newVersion: String) {
        properties.setProperty("version", newVersion)
        properties.store(propertyFile.writer(), null)
        properties.load(propertyFile.inputStream())
    }
}