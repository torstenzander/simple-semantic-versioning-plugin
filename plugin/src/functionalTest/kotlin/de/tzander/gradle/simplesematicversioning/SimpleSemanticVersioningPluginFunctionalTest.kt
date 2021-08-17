package de.tzander.gradle.simplesematicversioning

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertTrue

class SimpleSemanticVersioningPluginFunctionalTest {

    lateinit var projectDir: File

    @Before fun setUp(){
        projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("version.gradle").writeText("version=12.4.2")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('de.tzander.gradle.simplesematicversioning.increaseVersion')
            }
        """)
    }
    @Test fun `can run patch updatte`() {
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("increasePatch")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        assertTrue(result.output.contains("12.4.3"))
    }

    @Test fun `can run minor update`() {
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("increaseMinor")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        assertTrue(result.output.contains("12.5.0"))
    }

    @Test fun `can run major update`() {
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("increaseMajor")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        assertTrue(result.output.contains("13.0.0"))
    }
}
