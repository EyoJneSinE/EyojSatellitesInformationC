package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper

import com.eniskaner.eyojsatellitesinformation.core.data.Mapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.PositionDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.PositionListDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatelliteDetailDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatellitePositionDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.entity.SatelliteDetailEntity
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.PositionUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatelliteDetailModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatellitePositionUIModel

/**
 * PositionDTO to PositionUIModel Mapper
 */
class PositionDTOToUIMapper : Mapper<PositionDTO, PositionUIModel> {
    override fun map(input: PositionDTO): PositionUIModel {
        return PositionUIModel(
            posX = input.posX,
            posY = input.posY
        )
    }
}

/**
 * SatelliteDetailDTO to SatelliteDetailUIModel Mapper
 */
class SatelliteDetailDTOToUIModelMapper : Mapper<SatelliteDetailDTO, SatelliteDetailModel> {
    override fun map(input: SatelliteDetailDTO): SatelliteDetailModel {
        return SatelliteDetailModel(
            id = input.id,
            costPerLaunch = input.costPerLaunch,
            firstFlight = input.firstFlight,
            height = input.height,
            mass = input.mass
        )
    }
}

/**
 * SatellitePositionDTO to SatellitePositionUIModel Mapper
 */
class SatellitePositionDTOToUIMapper(
    private val positionMapper: PositionDTOToUIMapper
) : Mapper<SatellitePositionDTO, SatellitePositionUIModel> {
    override fun map(input: SatellitePositionDTO): SatellitePositionUIModel {
        return SatellitePositionUIModel(
            id = input.id,
            positions = input.positions.map { positionMapper.map(it) }
        )
    }
}

/**
 * SatellitePositionDTO to SatellitePositionUIModel Mapper
 */
class PositionListDTOToUIMapper(
    private val satellitePositionMapper: SatellitePositionDTOToUIMapper
) : Mapper<PositionListDTO, List<SatellitePositionUIModel>> {
    override fun map(input: PositionListDTO): List<SatellitePositionUIModel> {
        return input.list.map { satellitePositionMapper.map(it) }
    }
}

/**
 * SatelliteDetailDTO to SatelliteDetailEntity Mapper
 */
class SatelliteDetailDTOToEntity : Mapper<SatelliteDetailDTO, SatelliteDetailEntity> {
    override fun map(input: SatelliteDetailDTO): SatelliteDetailEntity {
        return SatelliteDetailEntity(
            id = input.id,
            costPerLaunch = input.costPerLaunch,
            firstFlight = input.firstFlight,
            height = input.height,
            mass = input.mass
        )
    }
}

/**
 * SatelliteDetailEntity to SatelliteDetailUI Mapper
 */
class SatelliteDetailEntityToUIModelMapper : Mapper<SatelliteDetailEntity, SatelliteDetailModel> {
    override fun map(input: SatelliteDetailEntity): SatelliteDetailModel {
        return SatelliteDetailModel(
            id = input.id,
            costPerLaunch = input.costPerLaunch,
            firstFlight = input.firstFlight,
            height = input.height,
            mass = input.mass
        )
    }
}
