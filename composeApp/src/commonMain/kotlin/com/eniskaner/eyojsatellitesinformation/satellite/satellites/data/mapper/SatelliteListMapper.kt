package com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.mapper

import com.eniskaner.eyojsatellitesinformation.core.data.Mapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.model.SatelliteDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel

/**
 * SatelliteDTO to SatelliteUIModel Mapper
 */
class SatelliteListDtoToUIModelMapper : Mapper<SatelliteDTO, SatelliteUIModel> {
    override fun map(input: SatelliteDTO): SatelliteUIModel {
        return SatelliteUIModel(
            id = input.id,
            isActive = input.active,
            name = input.name
        )
    }
}
