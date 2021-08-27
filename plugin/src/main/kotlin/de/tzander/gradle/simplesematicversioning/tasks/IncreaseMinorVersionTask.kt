package de.tzander.gradle.simplesematicversioning.tasks

import org.gradle.api.tasks.TaskAction

abstract class IncreaseMinorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMinor()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to minor version: $semanticVersion")
        replaceInFiles(extension)
    }
}