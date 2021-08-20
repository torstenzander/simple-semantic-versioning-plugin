#Simple Semantic Versioning Plugin

This plugin increases the version by one. You can define additonal files.

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