package com.example.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

@Suppress("UNCHECKED_CAST")
@Composable
inline fun <reified T: ViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelCreator: (handle: SavedStateHandle) -> T,
): T = androidx.lifecycle.viewmodel.compose.viewModel(
    modelClass = T::class.java,
    key = key,
    factory = object : AbstractSavedStateViewModelFactory() {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T = viewModelCreator(handle) as T
    }
)