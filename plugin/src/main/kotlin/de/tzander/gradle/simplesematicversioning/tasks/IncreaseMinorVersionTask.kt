package de.tzander.gradle.simplesematicversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMinorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMinor()
        propertyFileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to minor version: $semanticVersion")
        additionalFilesHandler.replaceInFiles(project.rootDir.toString(), extension.files, oldVersion, semanticVersion)

    }
}