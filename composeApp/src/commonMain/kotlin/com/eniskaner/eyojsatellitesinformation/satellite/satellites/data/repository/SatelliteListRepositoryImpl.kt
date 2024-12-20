package com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.repository

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.ErrorMessages.DEFAULT_ERROR_MESSAGE
import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.datasource.SatelliteListDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.mapper.SatelliteListDtoToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.repository.SatelliteListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SatelliteListRepositoryImpl(
    private val satelliteListDataSource: SatelliteListDataSource,
    private val satelliteListDtoToUIModelMapper: SatelliteListDtoToUIModelMapper
) : SatelliteListRepository {

    override suspend fun getSatelliteList(): Flow<Resource<List<SatelliteUIModel>>> = flow {
        emit(Resource.Loading())
        val satellites =
            satelliteListDataSource.getSatelliteList()
                .map { satelliteListDtoToUIModelMapper.map(it) }
        emit(Resource.Success(data = satellites))
    }.catch {
        emit(Resource.Error(message = it.message ?: DEFAULT_ERROR_MESSAGE))
    }

    override suspend fun search(query: String): Flow<Resource<List<SatelliteUIModel>>> = flow {
        emit(Resource.Loading())
        val satelliteListSearch =
            satelliteListDataSource.search(query = query)
                .map { satelliteListDtoToUIModelMapper.map(it) }
        emit(Resource.Success(data = satelliteListSearch))
    }.catch {
        emit(Resource.Error(message = it.message ?: DEFAULT_ERROR_MESSAGE))
    }
}
