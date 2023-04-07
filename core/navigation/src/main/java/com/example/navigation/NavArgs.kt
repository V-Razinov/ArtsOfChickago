package com.example.navigation

import androidx.navigation.NavType

fun intNavArgument(
    name: String,
    defValue: Int? = null
) = androidx.navigation.navArgument(name = name) {
    defaultValue = defValue
    type = NavType.IntType
}

fun stringNavArgument(
    name: String,
    defValue: String? = null
) = androidx.navigation.navArgument(name = name) {
    defaultValue = defValue
    type = NavType.StringType
}

fun booleanNavArgument(
    name: String,
    defValue: Boolean? = null
) = androidx.navigation.navArgument(name = name) {
    defaultValue = defValue
    type = NavType.BoolType
}