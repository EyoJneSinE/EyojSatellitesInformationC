package com.eniskaner.eyojsatellitesinformation.core.data

object Constants {

    object ErrorMessages {
        const val DEFAULT_ERROR_MESSAGE = "An error occurred!"
        const val SATELLITE_DETAIL_NOT_FOUND = "Satellite Detail not found."
    }

    object Delays {
        const val DEFAULT_DELAY = 1500L
        const val SATELLITE_POSITION_DELAY = 3000L
    }

    object DatabaseConstants {
        const val SATELLITE_DB_NAME = "satellites.db"
        const val SATELLITE_DETAIL_TABLE_NAME = "satellite_detail"
        const val DATABASE_FACTORY_NO_ACTUAL_FOR_EXPECT = "NO_ACTUAL_FOR_EXPECT"
    }

    object AssetConstants {
        const val SATELLITE_LIST = "satellite-list.json"
        const val SATELLITE_DETAIL = "satellite-detail.json"
        const val POSITIONS = "positions.json"
    }

    object DtoConstants {
        const val SATELLITE_COST_PER_LAUNCH = "cost_per_launch"
        const val SATELLITE_FIRST_FLIGHT = "first_flight"
    }

    object UIConstants {
        const val SATELLITE_STATUS_ICON = "Satellite status icon"
        const val SATELLITE_DETAIL_SCREEN_BACK_ICON = "("
        const val SATELLITE_DETAIL_SCREEN_CLOSE_ICON = ")"
        const val SATELLITE_DETAIL_SCREEN_SEPARATOR = ","
        const val SATELLITE_DETAIL_SCREEN_TITLE = "Satellite Detail"
    }
}
