package com.example.di

import javax.inject.Qualifier

object TypeConverterQualifier {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ListStringTypeConverter

}