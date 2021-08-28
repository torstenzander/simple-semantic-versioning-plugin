package de.tzander.gradle.simplesematicversioning

import kotlin.test.Test
import kotlin.test.assertEquals

class AdditionalFilesHandlerTest {

    @Test fun `test string replace`() {
        var prefix = "version="
        var text = "version=12.2.1\nversion: 12.2.1"
        text = text.replace(prefix+"12.2.1", prefix+"12.2.2")
        assertEquals("version=12.2.2\nversion: 12.2.1", text)
    }
}