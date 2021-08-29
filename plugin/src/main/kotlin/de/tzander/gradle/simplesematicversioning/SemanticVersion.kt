package de.tzander.gradle.simplesematicversioning

class SemanticVersion constructor(version: String) {

    var major: Int
    var minor: Int
    var patch: Int
    private var postfix: String = ""
    var oldVersion: String = version

    init {
        val versionParts = version.split(".", "-")
        major = versionParts[0].toInt()
        minor = versionParts[1].toInt()
        patch = versionParts[2].toInt()
        if (versionParts.size > 3) {
            val postfixString = versionParts[3]
            postfix = "-$postfixString"
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
        return "$major.$minor.$patch$postfix"
    }
}