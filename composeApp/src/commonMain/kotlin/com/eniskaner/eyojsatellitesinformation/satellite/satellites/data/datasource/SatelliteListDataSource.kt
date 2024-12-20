package com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.datasource

import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.model.SatelliteDTO

interface SatelliteListDataSource {

    suspend fun getSatelliteList(): List<SatelliteDTO>

    suspend fun search(query: String): List<SatelliteDTO>
}
