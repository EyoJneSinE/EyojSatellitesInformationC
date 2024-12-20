package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DatabaseConstants.SATELLITE_DETAIL_TABLE_NAME
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DtoConstants.SATELLITE_COST_PER_LAUNCH
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.DtoConstants.SATELLITE_FIRST_FLIGHT

@Entity(SATELLITE_DETAIL_TABLE_NAME)
data class SatelliteDetailEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(SATELLITE_COST_PER_LAUNCH)
    val costPerLaunch: Long,
    @ColumnInfo(SATELLITE_FIRST_FLIGHT)
    val firstFlight: String,
    val height: Int,
    val mass: Long
)
