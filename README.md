# Simple Semantic Versioning Plugin

[![Gradle Package](https://github.com/torstenzander/simple-semantic-versioning-plugin/actions/workflows/gradle-publish.yml/badge.svg?branch=main&event=push)](https://github.com/torstenzander/simple-semantic-versioning-plugin/actions/workflows/gradle-publish.yml)

This plugin increases the semantic version in **gradle.properties** by one 
for patch, minor and major version updates. 
You can define additional files in your gradle.build configuration and the matching prefix.
The prefix to be the same key number in the files and prefixes array in order to work.

i.E.
Only prefix=2.2.0 will be replaced in your additional files.

In gradle.properties
    
    version=12.2.1

```
plugins {
    id 'de.tzander.gradle.simplesematicversioning' version '0.8.0'
}

simplesematicversioning {
    files = [".gitlab-ci.yml", "Dockerfile"]
    prefixes = ["somePrefix", ""]
}
```

## Gradle task for increasing the version

`gradle increasePatch` 12.2.1 > 12.2.2

`gradle increaseMinor` 12.2.1 > 12.3.0

`gradle increaseMajor` 12.2.1 > 13.0.0


## Possible version declarations

* x.x.x
* x.x.x-XX
* x.x.x.XX

After the Version only - or . are allowed
