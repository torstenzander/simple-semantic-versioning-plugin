package de.torstenzander.gradle.simplesematicversioning

import de.torstenzander.gradle.simplesematicversioning.SematicVersion
import kotlin.test.Test
import kotlin.test.assertEquals

class SematicVersionTest {

    @Test fun `get major version`() {
        val sematicVersion = SematicVersion("12.2.1")
        assertEquals(12, sematicVersion.major)
        sematicVersion.increaseMajor()
        assertEquals("13.0.0", sematicVersion.toString())
    }

    @Test fun `get minor version`() {
        val sematicVersion = SematicVersion("12.2.1")
        assertEquals(2, sematicVersion.minor)
        sematicVersion.increaseMinor()
        assertEquals("12.3.0", sematicVersion.toString())
    }

    @Test fun `get patch version`() {
        val sematicVersion = SematicVersion("12.2.1")
        assertEquals(1, sematicVersion.patch)
        sematicVersion.increasePatch()
        assertEquals("12.2.2", sematicVersion.toString())
    }

    @Test fun `can handle snapshot patch version`() {
        val sematicVersion = SematicVersion("12.2.1-SNAPSHOT")
        assertEquals(1, sematicVersion.patch)
        sematicVersion.increasePatch()
        assertEquals("12.2.2-SNAPSHOT", sematicVersion.toString())
    }

    @Test fun `can handle snapshot minor version`() {
        val sematicVersion = SematicVersion("12.2.1-SNAPSHOT")
        assertEquals(1, sematicVersion.patch)
        sematicVersion.increaseMinor()
        assertEquals("12.3.0-SNAPSHOT", sematicVersion.toString())
    }
}