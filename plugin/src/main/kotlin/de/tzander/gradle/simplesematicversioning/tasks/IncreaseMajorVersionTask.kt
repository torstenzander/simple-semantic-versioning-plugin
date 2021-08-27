package de.tzander.gradle.simplesematicversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMajorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMajor()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to major version: $semanticVersion")
        replaceInFiles(extension)
    }

}


