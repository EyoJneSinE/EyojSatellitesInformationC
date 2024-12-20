package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PositionListDTO(
    val list: List<SatellitePositionDTO>
)
