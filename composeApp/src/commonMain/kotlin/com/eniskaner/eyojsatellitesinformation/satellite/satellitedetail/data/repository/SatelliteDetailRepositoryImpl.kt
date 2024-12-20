package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.repository

import com.eniskaner.eyojsatellitesinformation.core.data.Constants.ErrorMessages.DEFAULT_ERROR_MESSAGE
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.ErrorMessages.SATELLITE_DETAIL_NOT_FOUND
import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailLocalDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailDTOToEntity
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailDTOToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailEntityToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatellitePositionDTOToUIMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatelliteDetailModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.model.SatellitePositionUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.repository.SatelliteDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SatelliteDetailRepositoryImpl(
    private val satelliteDetailDataSource: SatelliteDetailDataSource,
    private val satelliteDetailLocalDataSource: SatelliteDetailLocalDataSource,
    private val satelliteDetailDtoToUIModelMapper: SatelliteDetailDTOToUIModelMapper,
    private val satelliteDetailEntityToUIModelMapper: SatelliteDetailEntityToUIModelMapper,
    private val satelliteDetailDTOToEntity: SatelliteDetailDTOToEntity,
    private val satellitePositionDTOToUIMapper: SatellitePositionDTOToUIMapper
) : SatelliteDetailRepository {

    override suspend fun getSatelliteDetail(id: Int): Flow<Resource<SatelliteDetailModel>> = flow {
        emit(Resource.Loading())

        val localSatelliteDetail = satelliteDetailLocalDataSource.getSatelliteDetail(id)
        if (localSatelliteDetail != null) {

            val mappedDetail = satelliteDetailEntityToUIModelMapper.map(localSatelliteDetail)
            emit(Resource.Success(data = mappedDetail))
            return@flow
        }

        val remoteSatelliteDetail = satelliteDetailDataSource.getSatelliteDetail(id)
        if (remoteSatelliteDetail != null) {

            val satelliteDetailUI = satelliteDetailDtoToUIModelMapper.map(remoteSatelliteDetail)

            val entity = satelliteDetailDTOToEntity.map(remoteSatelliteDetail)
            satelliteDetailLocalDataSource.saveSatelliteDetail(entity)

            emit(Resource.Success(data = satelliteDetailUI))
            return@flow
        }

        emit(Resource.Error(message = SATELLITE_DETAIL_NOT_FOUND))
    }.catch { exception ->
        emit(Resource.Error(message = exception.message ?: DEFAULT_ERROR_MESSAGE))
    }

    override suspend fun getSatellitePosition(id: Int): Flow<Resource<SatellitePositionUIModel?>> =
        flow {
            emit(Resource.Loading())
            val satellitePosition = satelliteDetailDataSource.getSatellitePositions(id = id)
                ?.let { satellitePositionDTOToUIMapper.map(it) }
            emit(Resource.Success(data = satellitePosition))
        }.catch {
            emit(Resource.Error(message = it.message ?: DEFAULT_ERROR_MESSAGE))
        }
}
