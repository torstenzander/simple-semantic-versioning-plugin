package de.torstenzander.gradle.simplesematicversioning

import de.torstenzander.gradle.simplesematicversioning.tasks.IncreaseMajorVersionTask
import de.torstenzander.gradle.simplesematicversioning.tasks.IncreaseMinorVersionTask
import de.torstenzander.gradle.simplesematicversioning.tasks.IncreasePatchVersionTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class SimpleSemanticVersioningPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("simplesematicversioning", SimpleSemanticVersioningExtension::class.java)
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
