package com.example.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Loading<T>(val data: T?) : Result<T>
    data class Error(val error: Throwable) : Result<Nothing>
}

@Suppress("UNCHECKED_CAST")
fun <T> Flow<T>.asResult(): Flow<Result<T>> =
    this
        .map<T, Result<T>> { Result.Success(it) }
        .onStart { emit(Result.Loading(null)) }
        .catch { t -> emit(Result.Error(t)) }
