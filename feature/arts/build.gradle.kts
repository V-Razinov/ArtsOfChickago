@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.core
import modules.domain
import modules.projectModules
import modules.utils

plugins {
    library
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = "com.example.arts"
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
        compose = true
        buildConfig = true
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
    projectModules {
        core {
            implementation(project(dispatchers))
            implementation(project(navigation))
            implementation(project(ui))
        }
        domain {
            implementation(project(arts))
        }
        implementation(project(utils))
    }
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
        coil {
            implementation(core)
        }
    }
}

kapt {
    correctErrorTypes = true
}