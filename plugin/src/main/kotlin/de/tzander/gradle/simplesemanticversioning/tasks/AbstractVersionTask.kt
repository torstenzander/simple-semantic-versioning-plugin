package de.tzander.gradle.simplesemanticversioning.tasks

import de.tzander.gradle.simplesemanticversioning.AdditionalFilesHandler
import de.tzander.gradle.simplesemanticversioning.PropertyFileHandler
import de.tzander.gradle.simplesemanticversioning.SemanticVersion
import de.tzander.gradle.simplesemanticversioning.SimpleSemanticVersioningExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

abstract class AbstractVersionTask : DefaultTask() {

    @get:Input
    var propertyFileHandler: PropertyFileHandler = PropertyFileHandler(project.properties["projectDir"].toString())

    @get:Input
    var oldVersion: String = propertyFileHandler.readVersionFromFile()

    @get:Input
    var semanticVersion: SemanticVersion = SemanticVersion(oldVersion)

    @get:Input
    var additionalFilesHandler: AdditionalFilesHandler = AdditionalFilesHandler(semanticVersion)

    @get:Input
    val extension: SimpleSemanticVersioningExtension = project.extensions.getByType(SimpleSemanticVersioningExtension::class.java)

}