import org.gradle.plugin.use.PluginDependenciesSpec

fun appPlugins(block: Plugins.() -> Unit) = Plugins.block()

object Plugins {
    val PluginDependenciesSpec.gradle get() = id("com.android.application")
    val PluginDependenciesSpec.kotlin get() = id("org.jetbrains.kotlin.android")
    val PluginDependenciesSpec.kotlinKapt get() = id("kotlin-kapt")
    val PluginDependenciesSpec.library get() = id("com.android.library")
    val PluginDependenciesSpec.hilt get() = id("com.google.dagger.hilt.android")
}