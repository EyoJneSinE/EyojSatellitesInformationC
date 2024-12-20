package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase

import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.repository.SatelliteDetailRepository

class GetSatelliteDetailUseCase(
    private val satelliteDetailRepository: SatelliteDetailRepository
) {
    suspend operator fun invoke(id: Int) =
        satelliteDetailRepository.getSatelliteDetail(id)
}
