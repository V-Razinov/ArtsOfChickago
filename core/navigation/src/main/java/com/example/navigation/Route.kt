package com.example.navigation

import kotlin.reflect.KProperty

@JvmInline
value class Route(val value: String)

operator fun Route.getValue(thisObj: Any?, property: KProperty<*>): String = value

fun <T> Route.withParam(paramName: String, paramValue: T): Route =
    Route(this.value.replace("{$paramName}", paramValue.toString()))

fun <T> Route.withParams(vararg pairs: Pair<String, T>): Route {
    var route: Route = this
    pairs.forEach { (name, value) -> route = route.withParam(name, value) }
    return route
}