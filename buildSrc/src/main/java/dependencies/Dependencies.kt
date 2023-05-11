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
        private const val rootVersion = "1.4.2"

        const val ui = "androidx.compose.ui:ui:$rootVersion"
        const val runtime = "androidx.compose.runtime:runtime:$rootVersion"
        const val material = "androidx.compose.material:material:$rootVersion"
        const val material3 = "androidx.compose.material3:material3:1.1.0-alpha08"
        const val materialIcons = "androidx.compose.material:material:1.4.1"

        const val navigation = "androidx.navigation:navigation-compose:2.5.3"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$rootVersion"

        const val composeUiiTooling = "androidx.compose.ui:ui-tooling:$rootVersion"
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:$rootVersion"
    }

    object Hilt {
        private const val version = "2.45"
        const val core = "com.google.dagger:hilt-android:$version"
        const val coreTesting = "com.google.dagger:hilt-android-testing:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val viewModel = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object JsonConverter {
        const val gson = "com.google.code.gson:gson:2.10.1"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }

    object Room {
        private const val version = "2.5.1"
        const val core = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val testing = "androidx.room:room-testing:$version"
        const val paging = "androidx.room:room-paging:$version"
    }

    object Coil {
        const val core = "io.coil-kt:coil-compose:2.3.0"
        const val gif = "io.coil-kt:coil-gif:2.3.0"
    }

    object Paging {
        const val core = "androidx.paging:paging-runtime:3.1.1"
        const val compose = "androidx.paging:paging-compose:1.0.0-alpha18"
    }

    object LeekCanary {
        const val core = "com.squareup.leakcanary:leakcanary-android:2.10"
    }

    object Test {
        const val extJUnit = "androidx.test.ext:junit:1.1.4"
        const val runner = "androidx.test:runner:1.5.2"

        const val jUnit = "junit:junit:4.13.2"

        const val composeUi = "androidx.compose.ui:ui-test-junit4:1.3.3"

        const val mockitoCore = "org.mockito:mockito-core:5.2.0"
        const val mockitoKt = "org.mockito.kotlin:mockito-kotlin:3.2.0"

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    }

}