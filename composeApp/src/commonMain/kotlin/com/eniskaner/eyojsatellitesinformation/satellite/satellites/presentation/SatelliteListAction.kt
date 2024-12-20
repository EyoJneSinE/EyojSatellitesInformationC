package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation

import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel

sealed interface SatelliteListAction {

    data class OnSearchQueryChange(val query: String) : SatelliteListAction
    data class OnSatelliteClick(val satellite: SatelliteUIModel) : SatelliteListAction

}
