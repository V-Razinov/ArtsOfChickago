package com.example.artsofchickago

import androidx.lifecycle.ViewModel
import com.example.navigation.router.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val router: Router,
) : ViewModel()