@file:Suppress("UnstableApiUsage")

import dependencies.appDependencies
import dependencies.hilt
import modules.data
import modules.projectModules

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.artsdata_testing"
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
        data {
            implementation(project(arts))
        }
    }

    appDependencies {
        hilt {
            implementation(core)
            implementation(coreTesting)
            kapt(compiler)
        }
    }

}