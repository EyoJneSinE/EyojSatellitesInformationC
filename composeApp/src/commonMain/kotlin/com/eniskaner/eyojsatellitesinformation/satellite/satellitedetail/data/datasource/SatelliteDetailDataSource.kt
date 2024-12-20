package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatelliteDetailDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatellitePositionDTO

interface SatelliteDetailDataSource {

    suspend fun getSatelliteDetail(id: Int): SatelliteDetailDTO?

    suspend fun getSatellitePositions(id: Int): SatellitePositionDTO?
}
