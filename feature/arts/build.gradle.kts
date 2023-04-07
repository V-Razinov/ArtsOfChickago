@file:Suppress("UnstableApiUsage")

import dependencies.*

plugins {
    appPlugins {
        library
        kotlin
        kotlinKapt
        hilt
    }
}

android {
    namespace = "com.example.arts"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
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
        lifecycle {
            implementation(runtime)
            implementation(viewModel)
        }
        activity {
            implementation(viewModel)
        }
        compose {
            implementation(ui)
            implementation(toolingPreview)
            implementation(material3)
            implementation(navigation)
            debugImplementation(composeUiiTooling)
            debugImplementation(composeUiTestManifest)
        }
        hilt {
            implementation(core)
            implementation(viewModel)
            kapt(compiler)
        }
//        dagger {
//            implementation(core)
//            kapt(compiler)
//        }
    }
}