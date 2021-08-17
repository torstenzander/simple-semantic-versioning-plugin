package de.tzander.gradle.simplesematicversioning

class SematicVersion constructor(val version: String) {
    var major: Int
    var minor: Int
    var patch: Int
    var snapshot: String = ""

    init {
        val versionParts = version.split(".", "-")
        major = versionParts.get(0).toInt()
        minor = versionParts.get(1).toInt()
        patch = versionParts.get(2).toInt()
        if(versionParts.size > 3){
            var snapshotString = versionParts.get(3)
            snapshot = "-$snapshotString"
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
        return "$major.$minor.$patch$snapshot"
    }
}