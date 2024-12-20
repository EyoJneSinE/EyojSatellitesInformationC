package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.state

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel

data class SatelliteDetailState(
    val satelliteDetail: SatelliteDetailUIModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
