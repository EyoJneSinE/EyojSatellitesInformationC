package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.entity.SatelliteDetailEntity

interface SatelliteDetailLocalDataSource {

    suspend fun getSatelliteDetail(id: Int): SatelliteDetailEntity?

    suspend fun saveSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity)
}
