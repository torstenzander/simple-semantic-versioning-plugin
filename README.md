# Simple Semantic Versioning Plugin

This plugin increases the semantic version in **version.gradle** by one 
for patch, minor and major version updates. 
You can define additional files in your gradle.build configuration.

**Be aware that this plugin only replaces the version number. 
In case you have a file with the several same version numbers I won't work.**

```
plugins {
    id 'de.tzander.gradle.simplesematicversioning' version '0.2.0'
}

simplesematicversioning {
    files = [".gitlab-ci.yml", "Dockerfile"]
}
```

## Gradle task for increasing the version

`./gradlew increasePatch`

`./gradlew increaseMinor`

`./gradlew increaseMajor`


## Possible version declarations

* x.x.x
* x.x.x-SOMESTRING (like SNAPSHOT OR RELEASE) 

more to come.