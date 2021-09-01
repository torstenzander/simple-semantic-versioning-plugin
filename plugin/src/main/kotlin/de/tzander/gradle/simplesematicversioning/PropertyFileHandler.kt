package de.tzander.gradle.simplesematicversioning

import java.io.File
import java.util.*

class PropertyFileHandler constructor(private val projectDir: String) {

    private val propertyFile = "/gradle.properties"
    private var properties: Properties = Properties()
    private lateinit var file: File

    fun readVersionFromFile(): String {
        file = File(projectDir + propertyFile)
        properties.load(file.inputStream())
        return properties.getProperty("version")
    }

    fun savePropertyToFile(newVersion: String) {
        properties.setProperty("version", newVersion)
        properties.store(file.writer(), null)
        properties.load(file.inputStream())
    }

}