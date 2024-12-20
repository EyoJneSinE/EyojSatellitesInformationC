package com.eniskaner.eyojsatellitesinformation.di

import com.eniskaner.eyojsatellitesinformation.core.data.ResourceReader
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database.DatabaseFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { ResourceReader(androidContext().assets) }
    single { DatabaseFactory(androidApplication()) }
}