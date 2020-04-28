import org.jetbrains.kotlin.gradle.plugin.LanguageSettingsBuilder

plugins {
    kotlin("multiplatform")  version "1.3.72"
    kotlin("plugin.serialization") version "1.3.70"

}

group = "app.roomtorent"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    val serializationVersion = "0.20.0"
    val ktorVersion = "1.3.2"

    val settings: LanguageSettingsBuilder.() -> Unit = {
        languageVersion = "1.4" // possible values: '1.0', '1.1', '1.2', '1.3'
        apiVersion = "1.4" // possible values: '1.0', '1.1', '1.2', '1.3'
        enableLanguageFeature("InlineClasses") // language feature name
//        useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes") // annotation FQ-name

        progressiveMode = true // false by default
    }
    sourceSets {
        val commonMain by getting {
            languageSettings.apply(settings)
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("com.github.kittinunf.fuel:fuel:2.2.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
            }
        }
        val commonTest by getting {
            languageSettings.apply(settings)

            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")

            }
        }

        // Default source set for JVM-specific sources and dependencies:
        jvm().compilations["main"].defaultSourceSet {
            languageSettings.apply(settings)

            kotlin.srcDir("src/main/kotlin")
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("com.beust:klaxon:5.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-server-core:$ktorVersion")
                implementation("io.ktor:ktor-server-netty:$ktorVersion")

            }
        }
        // JVM-specific tests and their dependencies:
        jvm().compilations["test"].defaultSourceSet {
            languageSettings.apply(settings)

            kotlin.srcDir("src/test/kotlin")
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")

            }
        }
    }
}

tasks {
//    compileKotlin {
//        kotlinOptions.jvmTarget = "1.8"
//    }
//    compileTestKotlin {
//        kotlinOptions.jvmTarget = "1.8"
//    }
}
