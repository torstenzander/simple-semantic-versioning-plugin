plugins {
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm") version "1.4.31"
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.14.0"
}

group = "de.tzander.gradle.simplesemanticversioning"
version = "0.9.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-bom")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

pluginBundle {
    website = "https://github.com/torstenzander/simple-semantic-versioning-plugin"
    vcsUrl = "https://github.com/torstenzander/simple-semantic-versioning-plugin.git"
    tags = listOf("version", "semantic", "increase")
}

gradlePlugin {
    plugins {
        create("simplesemanticversioning") {
            id = "de.tzander.gradle.simplesemanticversioning"
            displayName = "Simple Semantic Versioning Plugin"
            description = "This plugin increases semantic versions by one. You can define additional files."
            implementationClass = "de.tzander.gradle.simplesemanticversioning.SimpleSemanticVersioningPlugin"
        }
    }
}

val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])

val functionalTest by tasks.registering(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
}

tasks.check {
    dependsOn(functionalTest)
}

