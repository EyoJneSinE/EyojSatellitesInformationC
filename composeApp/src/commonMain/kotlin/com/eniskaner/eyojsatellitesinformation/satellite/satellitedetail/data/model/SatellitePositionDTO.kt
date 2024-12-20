package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SatellitePositionDTO(
    val id: Int,
    val positions: List<PositionDTO>
)
