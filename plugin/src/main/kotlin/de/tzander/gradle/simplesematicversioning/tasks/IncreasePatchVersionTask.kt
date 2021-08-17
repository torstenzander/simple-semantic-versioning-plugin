package de.tzander.gradle.simplesematicversioning.tasks

import de.tzander.gradle.simplesematicversioning.PropertyFileHandler
import de.tzander.gradle.simplesematicversioning.SematicVersion
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.util.*

abstract class IncreasePatchVersionTask : DefaultTask() {

    @TaskAction
    fun execute() {
        val fileHandler = PropertyFileHandler(project)
        val oldVersion = fileHandler.readVersionFromFile()
        val semanticVersion = SematicVersion(oldVersion)
        semanticVersion.increasePatch()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to patch version:$semanticVersion")
    }
}