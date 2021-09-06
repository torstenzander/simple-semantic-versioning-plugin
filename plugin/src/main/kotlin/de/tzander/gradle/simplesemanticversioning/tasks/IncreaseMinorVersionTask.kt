package de.tzander.gradle.simplesemanticversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMinorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMinor()
        propertyFileHandler.savePropertyToFile(semanticVersion.newVersion())

        println("Updated to minor version: ${semanticVersion.newVersion()}")
        additionalFilesHandler.replaceInFiles(project.rootDir.toString(), extension.files, extension.prefixes)

    }
}