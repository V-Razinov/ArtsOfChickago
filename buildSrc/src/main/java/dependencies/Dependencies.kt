package dependencies

object AppDependencies {

    object Android {
        const val core = "androidx.core:core-ktx:1.9.0"
    }

    object LifeCycle {
        private const val rootVersion = "2.6.0"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$rootVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:$rootVersion"
    }

    object Activity {
        const val viewModel = "androidx.activity:activity-compose:1.6.1"
    }

    object Compose {
        private const val rootVersion = "1.3.3"
        const val ui = "androidx.compose.ui:ui:$rootVersion"
        const val navigation = "androidx.navigation:navigation-compose:2.5.3"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$rootVersion"

        const val material3 = "androidx.compose.material3:material3:1.1.0-alpha08"
        const val materialIcons = "androidx.compose.material:material:1.4.1"

        const val composeUiiTooling = "androidx.compose.ui:ui-tooling:1.3.3"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:1.3.3"
    }

    object Hilt {
        private const val version = "2.45"
        const val core = "com.google.dagger:hilt-android:$version"
        const val viewModel = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Dagger {
        private const val version = "2.45"
        const val core = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object Coil {
        const val core = "io.coil-kt:coil-compose:2.3.0"
    }

    object LeekCanary {
        const val core = "com.squareup.leakcanary:leakcanary-android:2.10"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val extJUnit = "androidx.test.ext:junit:1.1.4"

        const val composeUi = "androidx.compose.ui:ui-test-junit4:1.3.3"

        const val mockitoCore = "org.mockito:mockito-core:5.2.0"
        const val mockitoKt = "org.mockito.kotlin:mockito-kotlin:3.2.0"
    }

}