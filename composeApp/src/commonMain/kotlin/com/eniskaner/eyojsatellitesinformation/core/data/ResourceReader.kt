package com.eniskaner.eyojsatellitesinformation.core.data

expect class ResourceReader {
    fun readJson(fileName: String): String
}
