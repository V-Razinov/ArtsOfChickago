import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.gradle: PluginDependencySpec
    get() = id("com.android.application")

val PluginDependenciesSpec.library: PluginDependencySpec
    get() = id("com.android.library")

val PluginDependenciesSpec.kotlin: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.android")

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id("kotlin-kapt")

val PluginDependenciesSpec.hilt: PluginDependencySpec
    get() = id("com.google.dagger.hilt.android")