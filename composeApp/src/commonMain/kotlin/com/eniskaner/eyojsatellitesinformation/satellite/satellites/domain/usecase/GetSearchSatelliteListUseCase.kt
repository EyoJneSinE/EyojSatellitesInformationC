package com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase

import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.repository.SatelliteListRepository

class GetSearchSatelliteListUseCase(
    private val satelliteRepository: SatelliteListRepository
) {

    suspend operator fun invoke(query: String) = satelliteRepository.search(query = query)
}
