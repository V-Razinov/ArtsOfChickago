package com.example.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class ResultTest {

    private val dispatcher = StandardTestDispatcher()

    @Test
    fun `asResult success returns Loading first`() = runTest(dispatcher) {
        val result: Result<Unit>? = flow { emit(Unit) }
            .asResult()
            .firstOrNull()
        assert(result is Result.Loading)
    }

    @Test
    fun `asResult success returns Success last`() = runTest(dispatcher) {
        val result: Result<Unit>? = flow { emit(Unit) }
            .asResult()
            .lastOrNull()
        assert(result is Result.Success)
    }

    @Test
    fun `asResult success don't return Error`() = runTest(dispatcher) {
        val results: List<Result<Unit>> = flow { emit(Unit) }
            .asResult()
            .toList()
        assert(results.all { it !is Result.Error })
    }

    @Test
    fun `asResult fail returns Loading first`() = runTest(dispatcher) {
        val result: Result<Unit>? = flow { emit(Unit) }
            .map { throw Exception("test exception") }
            .asResult()
            .firstOrNull()
        assert(result is Result.Loading)
    }

    @Test
    fun `asResult fail returns Error last`() = runTest(dispatcher) {
        val result: Result<Unit>? = flow { emit(Unit) }
            .map { throw Exception("test exception") }
            .asResult()
            .lastOrNull()
        assert(result is Result.Error)
    }

    @Test
    fun `asResult fail don't returns Success`() = runTest(dispatcher) {
        val results: List<Result<Unit>> = flow { emit(Unit) }
            .map { throw Exception("test exception") }
            .asResult()
            .toList()
        assert(results.all { it !is Result.Success })
    }

}