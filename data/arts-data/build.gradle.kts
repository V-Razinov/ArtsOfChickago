@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.core
import modules.data
import modules.projectModules
import modules.utils

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.artsdata"
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
            implementation(project(common))
            implementation(project(dispatchers))
            implementation(project(network))
        }
        data {
            implementation(project(common))
        }
        implementation(project(utils))
    }

    appDependencies {
        android {
            implementation(core)
        }
        hilt {
            implementation(core)
            kapt(compiler)
        }
        retrofit {
            implementation(core)
        }
        room {
            implementation(core)
            implementation(ktx)
            implementation(paging)
            kapt(compiler)
        }
    }
}