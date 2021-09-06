package de.tzander.gradle.simplesemanticversioning

import de.tzander.gradle.simplesemanticversioning.tasks.IncreaseMajorVersionTask
import de.tzander.gradle.simplesemanticversioning.tasks.IncreaseMinorVersionTask
import de.tzander.gradle.simplesemanticversioning.tasks.IncreasePatchVersionTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class SimpleSemanticVersioningPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("simplesemanticversioning", SimpleSemanticVersioningExtension::class.java)
        project.run {
            tasks.apply {
                register("increasePatch", IncreasePatchVersionTask::class.java) {
                    it.group = "increasePatch"
                }
                register("increaseMinor", IncreaseMinorVersionTask::class.java) {
                    it.group = "increaseMinor"
                }
                register("increaseMajor", IncreaseMajorVersionTask::class.java) {
                    it.group = "increaseMajor"
                }

            }

        }
    }
}
