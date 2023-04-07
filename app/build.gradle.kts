@file:Suppress("UnstableApiUsage")

import dependencies.*
import modules.*

plugins {
    appPlugins {
        gradle
        kotlin
        kotlinKapt
        hilt
    }
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
//    flavorDimensions += "leeks"
//    productFlavors {
//        create("leekCanary") {
//            dimension = "leeks"
//            applicationIdSuffix = ".leek_canary"
//            versionNameSuffix = "-leek_canary"
//        }
//        create("noLeekCanary") {
//            dimension = "leeks"
//        }
//    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
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
            implementation(project(network))
            implementation(project(navigation))
            implementation(project(ui))
        }
        data {
            implementation(project(artOfChicago))
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
        implementation(AppDependencies.Coil.core)
        retrofit {
            implementation(core)
            implementation(gsonConverter)
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
//        leekCanary {
//            debugImplementation(core)
//        }
        test {
            testImplementation(jUnit)
            androidTestImplementation(extJUnit)
            androidTestImplementation(composeUi)
        }

    }
}
//
//kapt {
//    correctErrorTypes = true
//}
//
//hilt {
//    enableAggregatingTask = true
//}