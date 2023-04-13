@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.core
import modules.projectModules

plugins {
    appPlugins {
        library
        kotlin
        kotlinKapt
        hilt
    }
}

android {
    namespace = "com.example.artsofchicago"
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
        core {
            implementation(project(network))
        }
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
        test {
            testImplementation(jUnit)
            testImplementation(extJUnit)
            testImplementation(mockitoCore)
            testImplementation(mockitoKt)
        }
    }
}