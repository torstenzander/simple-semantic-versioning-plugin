package de.tzander.gradle.simplesematicversioning.tasks

import de.tzander.gradle.simplesematicversioning.SimpleSemanticVersioningExtension
import org.gradle.api.tasks.TaskAction

abstract class IncreasePatchVersionTask : AbstractVersionTask() {

    @TaskAction
    fun execute() {
        semanticVersion.increasePatch()
        fileHandler.savePropertyToFile(semanticVersion.toString())

        println("Updated to patch version:$semanticVersion")
        replaceInFiles(extension)
    }
}