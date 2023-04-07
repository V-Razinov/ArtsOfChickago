package com.example.artsofchickago

import leakcanary.AppWatcher

class LeekCanaryDetector : LeekDetector {
    override fun watchObject(obj: Any, description: String) {
        AppWatcher.objectWatcher.expectWeaklyReachable(obj, description)
    }
}