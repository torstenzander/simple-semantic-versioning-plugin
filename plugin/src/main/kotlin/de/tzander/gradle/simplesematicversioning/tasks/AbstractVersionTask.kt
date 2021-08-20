package de.tzander.gradle.simplesematicversioning.tasks

import de.tzander.gradle.simplesematicversioning.PropertyFileHandler
import de.tzander.gradle.simplesematicversioning.SematicVersion
import de.tzander.gradle.simplesematicversioning.SimpleSemanticVersioningExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import java.io.File

abstract class AbstractVersionTask : DefaultTask() {
    @get:Input
    var fileHandler: PropertyFileHandler = PropertyFileHandler(project)

    @get:Input
    var oldVersion: String = fileHandler.readVersionFromFile()

    @get:Input
    var semanticVersion: SematicVersion = SematicVersion(oldVersion)

    @get:Input
    val extension = project.extensions.getByType(SimpleSemanticVersioningExtension::class.java)

    protected fun replaceInFiles(extension: SimpleSemanticVersioningExtension) {
        extension.files?.forEach {
            val rootDir = project.rootDir
            val file = File("$rootDir/$it")
            var text = file.readText()
            text = text.replace(oldVersion, semanticVersion.toString())
            file.writeText(text)
            println("File updated: $it")
        }
    }

}