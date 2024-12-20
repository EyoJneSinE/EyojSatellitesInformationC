package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.dao.SatelliteDetailDao
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.entity.SatelliteDetailEntity

@Database(
    entities = [SatelliteDetailEntity::class],
    version = 1,
    exportSchema = true
)
@ConstructedBy(SatelliteDetailDatabaseConstructor::class)
abstract class SatelliteDetailDatabase : RoomDatabase() {

    abstract fun getSatelliteDao(): SatelliteDetailDao
}
