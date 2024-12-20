package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database.SatelliteDetailDatabase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.entity.SatelliteDetailEntity

class SatelliteDetailLocalDataSourceImpl(
    private val satelliteDetailDatabase: SatelliteDetailDatabase
) : SatelliteDetailLocalDataSource {

    override suspend fun getSatelliteDetail(id: Int): SatelliteDetailEntity? =
        satelliteDetailDatabase.getSatelliteDao().getSatelliteDetail(id = id)

    override suspend fun saveSatelliteDetail(satelliteDetailEntity: SatelliteDetailEntity) =
        satelliteDetailDatabase.getSatelliteDao()
            .saveSatelliteDetail(satelliteDetailEntity = satelliteDetailEntity)
}
