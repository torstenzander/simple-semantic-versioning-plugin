package de.torstenzander.gradle.simplesematicversioning.tasks

import de.torstenzander.gradle.simplesematicversioning.SimpleSemanticVersioningExtension
import org.gradle.api.tasks.TaskAction

abstract class IncreaseMajorVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increaseMajor()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to major version:$semanticVersion")
        replaceInFiles(extension)
    }

}


