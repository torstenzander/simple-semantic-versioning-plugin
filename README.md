#Simple Semantic Versioning Plugin

This plugin increases semantic versions by one. You can define additinnal files.

`./gradlew increasePatch`

`./gradlew increaseMinor`

`./gradlew increaseMajor`


```
plugins {
    id 'de.tzander.gradle.simplesematicversioning' version '0.2.0'
}

simplesematicversioning {
    files = [".gitlab-ci.yml", "Dockerfile"]
}
```

##Possible version declarations

* x.x.x
* x.x.x-SOMESTRING (like SNAPSHOT OR RELEASE) 