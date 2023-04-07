package com.example.artsofchickago

class EmptyLeekDetector: LeekDetector {
    override fun watchObject(obj: Any, description: String) = Unit
}