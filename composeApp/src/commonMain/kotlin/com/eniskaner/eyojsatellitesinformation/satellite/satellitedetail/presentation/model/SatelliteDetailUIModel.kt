package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model

data class SatelliteDetailUIModel(
    val id: Int,
    val name: String,
    val costPerLaunch: Long,
    val firstFlight: String,
    val height: Int,
    val mass: Long,
    val posX: Double,
    val posY: Double
)
