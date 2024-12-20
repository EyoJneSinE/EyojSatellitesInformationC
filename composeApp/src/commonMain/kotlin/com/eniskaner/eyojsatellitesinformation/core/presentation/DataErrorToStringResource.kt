package com.eniskaner.eyojsatellitesinformation.core.presentation

import com.eniskaner.eyojsatellitesinformation.core.domain.DataError
import eyojsatellitesinformationc.composeapp.generated.resources.Res
import eyojsatellitesinformationc.composeapp.generated.resources.error_disk_full
import eyojsatellitesinformationc.composeapp.generated.resources.error_unknown

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}
