package com.eniskaner.eyojsatellitesinformation.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailDataSourceImpl
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailLocalDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.datasource.SatelliteDetailLocalDataSourceImpl
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.PositionDTOToUIMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailDTOToEntity
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailDTOToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatelliteDetailEntityToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.mapper.SatellitePositionDTOToUIMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.repository.SatelliteDetailRepositoryImpl
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database.DatabaseFactory
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database.SatelliteDetailDatabase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.repository.SatelliteDetailRepository
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase.GetSatelliteDetailUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase.GetSatellitePositionUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.viewmodel.SatelliteDetailViewModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.datasource.SatelliteListDataSource
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.datasource.SatelliteListDataSourceImpl
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.mapper.SatelliteListDtoToUIModelMapper
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.data.repository.SatelliteListRepositoryImpl
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.repository.SatelliteListRepository
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase.GetSatelliteListUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase.GetSearchSatelliteListUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SatelliteListViewModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SelectedSatelliteViewModel
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { Json { ignoreUnknownKeys = true } }
    single { SatelliteListDtoToUIModelMapper() }
    single { SatelliteDetailEntityToUIModelMapper() }
    single { SatelliteDetailDTOToEntity() }
    single { SatellitePositionDTOToUIMapper(PositionDTOToUIMapper()) }
    single { SatelliteDetailDTOToUIModelMapper() }
    singleOf(::SatelliteListDataSourceImpl).bind<SatelliteListDataSource>()
    singleOf(::SatelliteListRepositoryImpl).bind<SatelliteListRepository>()
    singleOf(::SatelliteDetailRepositoryImpl).bind<SatelliteDetailRepository>()
    singleOf(::SatelliteDetailDataSourceImpl).bind<SatelliteDetailDataSource>()
    singleOf(::SatelliteDetailLocalDataSourceImpl).bind<SatelliteDetailLocalDataSource>()
    singleOf(::GetSatelliteDetailUseCase)
    singleOf(::GetSatellitePositionUseCase)
    singleOf(::GetSatelliteListUseCase)
    singleOf(::GetSearchSatelliteListUseCase)
    viewModelOf(::SatelliteListViewModel)
    viewModelOf(::SelectedSatelliteViewModel)
    viewModelOf(::SatelliteDetailViewModel)
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<SatelliteDetailDatabase>().getSatelliteDao() }
}
