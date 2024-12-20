package com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SatelliteDTO(
    val id: Int,
    val active: Boolean,
    val name: String
)
