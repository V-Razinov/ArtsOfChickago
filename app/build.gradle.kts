@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.*

plugins {
    gradle
    kotlin
    kotlinKapt
    hilt
}

android {
    namespace = AppConfig.nameSpace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionname

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getAt("debug")
            isMinifyEnabled = true
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
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
        freeCompilerArgs += "-Xcontext-receivers"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    projectModules {
        core {
            implementation(project(dispatchers))
            implementation(project(network))
            implementation(project(navigation))
            implementation(project(testing))
            testImplementation(project(testing))
            implementation(project(ui))
        }
        data {
            implementation(project(arts))
        }
        domain {
            implementation(project(arts))
        }
        features {
            implementation(project(arts))
            implementation(project(splash))
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
        coil {
            implementation(core)
        }
        retrofit {
            implementation(core)
            implementation(gsonConverter)
        }
        hilt {
            implementation(core)
            implementation(coreTesting)
            implementation(viewModel)
            kapt(compiler)

            androidTestImplementation(coreTesting)
            kaptAndroidTest(compiler)

            testImplementation(coreTesting)
            kaptTest(compiler)
        }

        // tests
        test {
            implementation(runner)
            testImplementation(jUnit)
            testImplementation(extJUnit)
            testImplementation(mockitoCore)
            testImplementation(mockitoKt)
            testImplementation(coroutines)
            androidTestImplementation(composeUi)
        }
    }
}

kapt {
    correctErrorTypes = true
}