package de.tzander.gradle.simplesematicversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMajorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMajor()
        propertyFileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to major version: $semanticVersion")
        fileHandler.replaceInFiles(project.rootDir.toString(), extension.files, oldVersion, semanticVersion)
    }

}


