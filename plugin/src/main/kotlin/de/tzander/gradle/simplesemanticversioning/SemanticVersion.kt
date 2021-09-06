package de.tzander.gradle.simplesemanticversioning

class SemanticVersion constructor(version: String) {

    var major: Int
    var minor: Int
    var patch: Int
    var originalVersionString: String = version
    var oldVersionPlain: String

    init {
        val versionParts = version.split(".", "-")
        major = versionParts[0].toInt()
        minor = versionParts[1].toInt()
        try {
            patch = versionParts[2].toInt()
            oldVersionPlain = "$major.$minor.$patch"
        } catch (e: NumberFormatException) {
            throw fail("Version string not valid, only . and - allowed after semantic version")
        }
    }

    fun increasePatch() {
        patch += 1
    }

    fun increaseMinor() {
        minor += 1
        patch = 0
    }

    fun increaseMajor() {
        major += 1
        minor = 0
        patch = 0
    }

    fun newVersion(): String {
        return originalVersionString.replace(oldVersionPlain, "$major.$minor.$patch")
    }

    private fun fail(message: String): Nothing = throw IllegalArgumentException(message)
}