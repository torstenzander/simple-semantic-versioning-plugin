package de.tzander.gradle.simplesematicversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreasePatchVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increasePatch()
        propertyFileHandler.savePropertyToFile(semanticVersion.newVersion())

        println("Updated to patch version: ${semanticVersion.newVersion()}")
        additionalFilesHandler.replaceInFiles(project.rootDir.toString(), extension.files, extension.prefixes)
    }
}