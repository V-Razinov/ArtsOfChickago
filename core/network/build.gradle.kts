@file:Suppress("UnstableApiUsage")

import dependencies.android
import dependencies.appDependencies
import dependencies.hilt
import dependencies.retrofit

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        buildConfigField(
            "String",
            "ARTS_OF_CHICAGO_BASE_URL",
            "\"https://api.artic.edu/api/v1/\""
        )
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
        buildConfig = true
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
        android {
            implementation(core)
        }
        retrofit {
            implementation(core)
            implementation(gsonConverter)
            implementation(loggingInterceptor)
        }
        hilt {
            implementation(core)
            kapt(compiler)
        }
    }
}