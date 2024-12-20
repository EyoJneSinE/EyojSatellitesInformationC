package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DatabaseConstants.SATELLITE_DB_NAME

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<SatelliteDetailDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(SATELLITE_DB_NAME)

        return Room.databaseBuilder(
            context = context,
            name = dbFile.absolutePath
        )
    }
}