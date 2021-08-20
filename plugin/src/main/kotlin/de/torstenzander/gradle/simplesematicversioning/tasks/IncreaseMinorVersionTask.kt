package de.torstenzander.gradle.simplesematicversioning.tasks

import de.torstenzander.gradle.simplesematicversioning.SimpleSemanticVersioningExtension
import org.gradle.api.tasks.TaskAction

abstract class IncreaseMinorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMinor()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to minor version:$semanticVersion")
        replaceInFiles(extension)
    }
}