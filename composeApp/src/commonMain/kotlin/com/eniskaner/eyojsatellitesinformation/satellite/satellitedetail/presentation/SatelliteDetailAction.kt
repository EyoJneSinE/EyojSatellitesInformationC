package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel

sealed interface SatelliteDetailAction {
    data object OnBackClick : SatelliteDetailAction
    data class OnSelectedSatellite(val satelliteDetailUIModel: SatelliteDetailUIModel) :
        SatelliteDetailAction
}
