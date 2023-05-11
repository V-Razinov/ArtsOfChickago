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

rootProject.name = "ArtsOfChicago"

include(
    "app",

    "core:common",
    "core:dispatchers",
    "core:dispatchers-testing",
    "core:navigation",
    "core:network",
    "core:testing",
    "core:ui",

    "data:arts-data",
    "data:arts-data-testing",
    "data:common",

    "domain:artsdomain",

    "feature:arts",
    "feature:splash",

    "utils",
)
