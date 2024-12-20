package com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.repository

import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel
import kotlinx.coroutines.flow.Flow

interface SatelliteListRepository {

    suspend fun getSatelliteList(): Flow<Resource<List<SatelliteUIModel>>>

    suspend fun search(query: String): Flow<Resource<List<SatelliteUIModel>>>

}
