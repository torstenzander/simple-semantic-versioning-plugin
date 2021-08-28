package de.tzander.gradle.simplesematicversioning.tasks

import de.tzander.gradle.simplesematicversioning.AdditionalFilesHandler
import de.tzander.gradle.simplesematicversioning.PropertyFileHandler
import de.tzander.gradle.simplesematicversioning.SemanticVersion
import de.tzander.gradle.simplesematicversioning.SimpleSemanticVersioningExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

abstract class AbstractVersionTask : DefaultTask() {
    @get:Input
    var propertyFileHandler: PropertyFileHandler = PropertyFileHandler(project.properties["projectDir"].toString())

    @get:Input
    var additionalFilesHandler: AdditionalFilesHandler = AdditionalFilesHandler()

    @get:Input
    var oldVersion: String = propertyFileHandler.readVersionFromFile()

    @get:Input
    var semanticVersion: SemanticVersion = SemanticVersion(oldVersion)

    @get:Input
    val extension: SimpleSemanticVersioningExtension = project.extensions.getByType(SimpleSemanticVersioningExtension::class.java)

}