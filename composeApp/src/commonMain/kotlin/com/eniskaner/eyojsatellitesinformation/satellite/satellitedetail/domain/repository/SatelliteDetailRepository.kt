package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.repository

import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatelliteDetailModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatellitePositionUIModel
import kotlinx.coroutines.flow.Flow

interface SatelliteDetailRepository {

    suspend fun getSatelliteDetail(id: Int): Flow<Resource<SatelliteDetailModel>>

    suspend fun getSatellitePosition(id: Int): Flow<Resource<SatellitePositionUIModel?>>
}
