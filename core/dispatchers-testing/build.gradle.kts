@file:Suppress("UnstableApiUsage")

import dependencies.appDependencies
import dependencies.hilt
import dependencies.test
import modules.core
import modules.projectModules

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.dispatchers_testing"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    projectModules {
        core {
            implementation(project(testing))
            implementation(project(dispatchers))
        }
    }
    appDependencies {
        hilt {
            implementation(core)
            implementation(coreTesting)
            kapt(compiler)

            testImplementation(coreTesting)
            kaptTest(compiler)
        }
        test {
            testImplementation(runner)
            testImplementation(jUnit)
            testImplementation(extJUnit)
            implementation(coroutines)
            testImplementation(coroutines)
        }
    }
}

kapt {
    correctErrorTypes = true
}