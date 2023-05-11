@file:Suppress("UnstableApiUsage")

import dependencies.appDependencies
import dependencies.hilt
import dependencies.jsonConverter

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.common"
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
    appDependencies {
        jsonConverter {
            implementation(gson)
        }
        hilt {
            implementation(core)
            kapt(compiler)
        }
    }
}