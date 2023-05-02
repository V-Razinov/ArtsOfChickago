@file:Suppress("UnstableApiUsage")

import dependencies.android
import dependencies.appDependencies
import dependencies.hilt
import dependencies.test
import modules.core
import modules.domain
import modules.features
import modules.projectModules

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.testing"
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
    buildFeatures {
        buildConfig = false
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
            implementation(project(dispatchers))
            implementation(project(navigation))
            implementation(project(ui))
        }
        domain {
            implementation(project(arts))
        }
        features {
            implementation(project(arts))
        }
    }
    appDependencies {
        android {
            implementation(core)
        }
        hilt {
            implementation(core)
            implementation(coreTesting)
            kapt(compiler)

            androidTestImplementation(coreTesting)
            kaptAndroidTest(compiler)

            testImplementation(coreTesting)
            kaptTest(compiler)
        }
        test {
            implementation(runner)
            testImplementation(jUnit)
            testImplementation(extJUnit)
            testImplementation(mockitoCore)
            testImplementation(mockitoKt)
            testImplementation(coroutines)
            androidTestImplementation(composeUi)
        }
    }
}

kapt {
    correctErrorTypes = true
}