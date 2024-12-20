package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.AssetConstants.POSITIONS
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.AssetConstants.SATELLITE_DETAIL
import com.eniskaner.eyojsatellitesinformation.core.data.ResourceReader
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.PositionListDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatelliteDetailDTO
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.model.SatellitePositionDTO
import kotlinx.serialization.json.Json

class SatelliteDetailDataSourceImpl(
    private val resourceReader: ResourceReader,
    private val json: Json
) : SatelliteDetailDataSource {

    override suspend fun getSatelliteDetail(id: Int): SatelliteDetailDTO? {
        val jsonString = resourceReader.readJson(SATELLITE_DETAIL)
        val satelliteDetail = json.decodeFromString<List<SatelliteDetailDTO>>(jsonString)
        return satelliteDetail.find { it.id == id }
    }

    override suspend fun getSatellitePositions(id: Int): SatellitePositionDTO? {
        val jsonString = resourceReader.readJson(POSITIONS)
        val satellitePosition = json.decodeFromString<PositionListDTO>(jsonString)
        return satellitePosition.list.find { it.id == id }
    }
}
