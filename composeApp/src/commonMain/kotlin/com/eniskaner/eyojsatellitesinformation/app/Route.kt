package com.eniskaner.eyojsatellitesinformation.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object SatelliteGraph : Route

    @Serializable
    data object SatelliteList : Route

    @Serializable
    data class SatelliteDetail(val id: Int, val name: String) : Route
}
