package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state

import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel

data class SatelliteListUIState(
    val satelliteList: List<SatelliteUIModel> = emptyList(),
    val searchingSatelliteList: List<SatelliteUIModel> = emptyList(),
    val isLoading: Boolean = false,
    val query: String = "",
    val error: String? = null
)
