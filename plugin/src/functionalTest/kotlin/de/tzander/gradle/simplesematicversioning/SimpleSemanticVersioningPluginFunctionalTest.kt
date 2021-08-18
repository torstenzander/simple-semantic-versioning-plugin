package de.tzander.gradle.simplesematicversioning

import org.gradle.testkit.runner.BuildResult
import java.io.File
import org.gradle.testkit.runner.GradleRunner
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertTrue

class SimpleSemanticVersioningPluginFunctionalTest {

    private lateinit var projectDir: File

    @Before fun setUp(){
        projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("version.gradle").writeText("version=12.4.2")
        projectDir.resolve(".gitlab-ci.yml").writeText("12.4.2")
        projectDir.resolve("Dockerfile").writeText("12.4.2")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('de.tzander.gradle.simplesematicversioning')
            }
            simplesematicversioning {
                 files = [".gitlab-ci.yml", "Dockerfile"]
            }
        """)
    }
    @Test fun `can run patch update`() {
        val result = runGradleTask("increasePatch")

        assertTrue(result.output.contains("12.4.3"))
    }

    @Test fun `can run minor update`() {
        val result = runGradleTask("increaseMinor")

        assertTrue(result.output.contains("12.5.0"))
    }

    @Test fun `can run major update`() {
        val result = runGradleTask("increaseMajor")

        assertTrue(result.output.contains("13.0.0"))
    }

    @Test fun `can run major update in otherfile`() {
        val result = runGradleTask("increaseMajor")

        val file = File("$projectDir/.gitlab-ci.yml")
        val text = file.readText()

        assertTrue(text.contains("13.0.0"))
        assertTrue(result.output.contains("File updated: .gitlab-ci.yml"))
    }

    @Test fun `can run minor update in otherfile`() {
        val result = runGradleTask("increaseMinor")

        val file = File("$projectDir/.gitlab-ci.yml")
        val text = file.readText()

        assertTrue(text.contains("12.5.0"))
        assertTrue(result.output.contains("File updated: .gitlab-ci.yml"))
    }

    @Test fun `can run patch update in otherfile`() {
        val result = runGradleTask("increasePatch")

        val file = File("$projectDir/.gitlab-ci.yml")
        val text = file.readText()

        assertTrue(text.contains("12.4.3"))
        assertTrue(result.output.contains("File updated: .gitlab-ci.yml"))
        assertTrue(result.output.contains("File updated: Dockerfile"))
    }

    private fun runGradleTask(task: String): BuildResult {
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments(task)
        runner.withProjectDir(projectDir)
        return runner.build()
    }
}
