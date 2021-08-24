package de.tzander.gradle.simplesematicversioning

class SemanticVersion constructor(version: String) {
    var major: Int
    var minor: Int
    var patch: Int
    private var postfix: String = ""

    init {
        val versionParts = version.split(".", "-")
        major = versionParts[0].toInt()
        minor = versionParts[1].toInt()
        patch = versionParts[2].toInt()
        if (versionParts.size > 3) {
            val snapshotString = versionParts[3]
            postfix = "-$snapshotString"
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

    override fun toString(): String {
        return "$major.$minor.$patch$postfix"
    }
}