package com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.datasource

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.AssetConstants.SATELLITE_LIST
import com.eniskaner.eyojsatellitesinformation.core.data.ResourceReader
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.model.SatelliteDTO
import kotlinx.serialization.json.Json

class SatelliteListDataSourceImpl(
    private val resourceReader: ResourceReader,
    private val json: Json
) : SatelliteListDataSource {
    override suspend fun getSatelliteList(): List<SatelliteDTO> {
        val jsonString = resourceReader.readJson(SATELLITE_LIST)
        return json.decodeFromString(jsonString)
    }

    override suspend fun search(query: String): List<SatelliteDTO> {
        val jsonString = resourceReader.readJson(SATELLITE_LIST)
        val satelliteList = json.decodeFromString<List<SatelliteDTO>>(jsonString)
        return satelliteList.filter { it.name.contains(query, ignoreCase = true) }
    }
}
