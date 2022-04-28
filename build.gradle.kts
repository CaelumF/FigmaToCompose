plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"

    // Apply the application plugin to add support for building a CLI application.
    application
}

group = "app.roomtorent"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val serializationVersion = "0.20.0"
val ktorVersion = "2.0.0"

dependencies {

    // Align versions of all Kotlin components
    implementation(platform(kotlin("bom")))

    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")

    // Ktor
    implementation("io.ktor:ktor-server:$ktorVersion")
    implementation("io.ktor:ktor-server-jetty:$ktorVersion")
    implementation("io.ktor:ktor-network-tls:$ktorVersion")

    // Utilities
    implementation("com.beust:klaxon:5.6")
    implementation("com.squareup:kotlinpoet:1.9.0")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")

    // Test
    testImplementation(kotlin("test-junit"))
}

application {
    mainClass.set("app.roomtorent.figmatocompose.EngineMain")
}

tasks {
    compileKotlin {
        kotlinOptions.apiVersion = "1.5"
        kotlinOptions.languageVersion = "1.5"
    }
}
