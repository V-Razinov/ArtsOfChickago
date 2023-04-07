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
    namespace = "com.example.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField(
            "String",
            "ARTS_OF_CHICAGO_BASE_URL",
            "\"https://api.artic.edu/api/v1/\""
        )
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
            implementation(core)
            implementation(gsonConverter)
        }
        hilt {
            implementation(core)
            kapt(compiler)
        }
    }
}