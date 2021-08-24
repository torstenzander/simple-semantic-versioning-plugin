package de.tzander.gradle.simplesematicversioning

import kotlin.test.Test
import kotlin.test.assertEquals

class SemanticVersionTest {

    @Test fun `get major version`() {
        val semanticVersion = SemanticVersion("12.2.1")
        assertEquals(12, semanticVersion.major)
        semanticVersion.increaseMajor()
        assertEquals("13.0.0", semanticVersion.toString())
    }

    @Test fun `get minor version`() {
        val semanticVersion = SemanticVersion("12.2.1")
        assertEquals(2, semanticVersion.minor)
        semanticVersion.increaseMinor()
        assertEquals("12.3.0", semanticVersion.toString())
    }

    @Test fun `get patch version`() {
        val semanticVersion = SemanticVersion("12.2.1")
        assertEquals(1, semanticVersion.patch)
        semanticVersion.increasePatch()
        assertEquals("12.2.2", semanticVersion.toString())
    }

    @Test fun `can handle snapshot patch version`() {
        val semanticVersion = SemanticVersion("12.2.1-SNAPSHOT")
        assertEquals(1, semanticVersion.patch)
        semanticVersion.increasePatch()
        assertEquals("12.2.2-SNAPSHOT", semanticVersion.toString())
    }

    @Test fun `can handle snapshot minor version`() {
        val semanticVersion = SemanticVersion("12.2.1-SNAPSHOT")
        assertEquals(1, semanticVersion.patch)
        semanticVersion.increaseMinor()
        assertEquals("12.3.0-SNAPSHOT", semanticVersion.toString())
    }

    @Test fun `can handle release with dot`() {
        val semanticVersion = SemanticVersion("12.2.1.RELEASE")
        assertEquals(1, semanticVersion.patch)
        semanticVersion.increaseMinor()
        assertEquals("12.3.0-RELEASE", semanticVersion.toString())
    }
}