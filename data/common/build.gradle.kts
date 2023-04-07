@file:Suppress("UnstableApiUsage")

import dependencies.android
import dependencies.appDependencies
import dependencies.hilt
import dependencies.retrofit

plugins {
    appPlugins {
        library
        kotlin
        kotlinKapt
        hilt
    }
}

android {
    namespace = "com.example.common"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    }
}