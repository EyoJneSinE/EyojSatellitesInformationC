package com.eniskaner.eyojsatellitesinformation.core.data

import android.content.res.AssetManager

actual class ResourceReader(private val assetManager: AssetManager) {
    actual fun readJson(fileName: String): String {
        return assetManager.open(fileName).bufferedReader().use { it.readText() }
    }
}