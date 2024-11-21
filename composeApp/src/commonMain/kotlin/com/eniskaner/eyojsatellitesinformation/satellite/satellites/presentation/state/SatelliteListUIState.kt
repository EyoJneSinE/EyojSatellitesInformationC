package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state

import com.eniskaner.eyojsatellitesinformation.core.presentation.UiText
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.SatelliteUIModel

data class SatelliteListUIState(
    val satelliteList: List<SatelliteUIModel> = emptyList(),
    val searchingSatelliteList: List<SatelliteUIModel> = satellites,
    val isLoading: Boolean = false,
    val query: String = "",
    val error: UiText? = null
)

val satellites = (1..40).map {
    SatelliteUIModel(
        id = it,
        isActive = false,
        name = "Starship-1"
    )
}
