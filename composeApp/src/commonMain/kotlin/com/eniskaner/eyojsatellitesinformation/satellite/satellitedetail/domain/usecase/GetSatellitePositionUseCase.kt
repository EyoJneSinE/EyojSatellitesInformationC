package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.Delays.SATELLITE_POSITION_DELAY
import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.PositionUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.repository.SatelliteDetailRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSatellitePositionUseCase(
    private val satelliteDetailRepository: SatelliteDetailRepository
) {
    operator fun invoke(id: Int): Flow<Resource<PositionUIModel?>> = flow {
        val satellitePosition = satelliteDetailRepository.getSatellitePosition(id)
        satellitePosition.collect { resource ->
            when (resource) {
                is Resource.Success -> {
                    var index = 0
                    val bound = resource.data?.positions?.size ?: 0
                    while (true) {
                        val position = resource.data?.positions?.getOrNull(index % bound)
                        emit(Resource.Success(position))
                        index++
                        delay(SATELLITE_POSITION_DELAY)
                    }
                }

                is Resource.Error -> emit(Resource.Error(resource.message ?: ""))

                is Resource.Loading -> emit(Resource.Loading())
            }
        }
    }
}
