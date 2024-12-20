package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DtoConstants.SATELLITE_COST_PER_LAUNCH
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DtoConstants.SATELLITE_FIRST_FLIGHT
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SatelliteDetailDTO(
    val id: Int,
    @SerialName(SATELLITE_COST_PER_LAUNCH)
    val costPerLaunch: Long,
    @SerialName(SATELLITE_FIRST_FLIGHT)
    val firstFlight: String,
    val height: Int,
    val mass: Long
)
