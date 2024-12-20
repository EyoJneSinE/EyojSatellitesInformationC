package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<SatelliteDetailDatabase>
}
