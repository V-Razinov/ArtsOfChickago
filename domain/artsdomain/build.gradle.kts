@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.*

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.artsdomain"
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
        }
        data {
            implementation(project(arts))
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
        paging {
            implementation(core)
        }
        room {
            implementation(core)
            implementation(ktx)
            kapt(compiler)
        }
    }
}