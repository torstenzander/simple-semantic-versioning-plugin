package de.tzander.gradle.simplesematicversioning

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.Before
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue

class AdditionalFilesPrefixFunctionalTest {

    private lateinit var projectDir: File

    @Before fun setUp(){
        projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("gradle.properties").writeText("version=12.4.2")
        projectDir.resolve(".gitlab-ci.yml").writeText("api.12.4.2")
        projectDir.resolve("Dockerfile").writeText("jar-12.4.2")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id("de.tzander.gradle.simplesematicversioning")
            }
            simplesematicversioning {
                files = [".gitlab-ci.yml", "Dockerfile"]
                prefixes = ["api.", "jar-"]
            }
        """)
    }

    @Test fun `increase major version in file with prefix`() {
        val result = runGradleTask("increaseMajor")

        val file = File("$projectDir/.gitlab-ci.yml")
        val text = file.readText()

        assertTrue(text.contains("api.13.0.0"))
        assertTrue(result.output.contains("File updated: .gitlab-ci.yml"))
    }

    @Test fun `increase minor version and update in configured file`() {
        val result = runGradleTask("increaseMinor")

        val file = File("$projectDir/.gitlab-ci.yml")
        val text = file.readText()

        assertTrue(text.contains("12.5.0"))
        assertTrue(result.output.contains("File updated: .gitlab-ci.yml"))
    }

    @Test fun `increase patch version and update in configured files`() {
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
