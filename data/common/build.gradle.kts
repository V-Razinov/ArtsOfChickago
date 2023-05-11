@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.core
import modules.projectModules

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
    projectModules {
        core {
            implementation(project(common))
        }
    }
    appDependencies {
        android {
            implementation(core)
        }
        retrofit {
            implementation(gsonConverter)
        }
        hilt {
            implementation(core)
            kapt(compiler)
        }
        room {
            implementation(core)
            kapt(compiler)
        }
    }
}