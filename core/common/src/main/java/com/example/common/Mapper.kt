package com.example.common

interface Mapper<T, R> {
    operator fun invoke(from: T): R
}