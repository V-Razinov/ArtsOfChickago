@file:Suppress("UnstableApiUsage")

import dependencies.android
import dependencies.appDependencies
import dependencies.hilt
import dependencies.test

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.dispatchers"
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
        android {
            implementation(core)
        }
        hilt {
            implementation(core)
            kapt(compiler)

            androidTestImplementation(coreTesting)
            kaptAndroidTest(compiler)

            testImplementation(coreTesting)
            kaptTest(compiler)
        }

        // tests
        test {
            testImplementation(jUnit)
            testImplementation(extJUnit)
            androidTestImplementation(coroutines)
            testImplementation(coroutines)
        }
    }
}