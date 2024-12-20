package com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase

import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.repository.SatelliteListRepository

class GetSatelliteListUseCase(
    private val satelliteListRepository: SatelliteListRepository
) {
    suspend operator fun invoke() = satelliteListRepository.getSatelliteList()
}
