package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database

import androidx.room.RoomDatabaseConstructor
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DatabaseConstants.DATABASE_FACTORY_NO_ACTUAL_FOR_EXPECT

@Suppress(DATABASE_FACTORY_NO_ACTUAL_FOR_EXPECT)
expect object SatelliteDetailDatabaseConstructor : RoomDatabaseConstructor<SatelliteDetailDatabase> {
    override fun initialize(): SatelliteDetailDatabase
}
