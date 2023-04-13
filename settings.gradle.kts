@file:Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ArtsOfChickago"

include(
    "app",

    "core:network",
    "core:navigation",
    "core:ui",

    "data:common",
    "data:artsdata",

    "domain:artsdomain",

    "feature:arts",
    "feature:splash",

    "utils",
)
