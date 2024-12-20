package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model

data class SatelliteDetailModel(
    val id: Int,
    val costPerLaunch: Long,
    val firstFlight: String,
    val height: Int,
    val mass: Long
)
