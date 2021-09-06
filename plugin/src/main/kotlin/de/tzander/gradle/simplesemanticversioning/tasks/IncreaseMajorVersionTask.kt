package de.tzander.gradle.simplesemanticversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMajorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMajor()
        propertyFileHandler.savePropertyToFile(semanticVersion.newVersion())

        println("Updated to major version: ${semanticVersion.newVersion()}")
        additionalFilesHandler.replaceInFiles(project.rootDir.toString(), extension.files, extension.prefixes)
    }

}


