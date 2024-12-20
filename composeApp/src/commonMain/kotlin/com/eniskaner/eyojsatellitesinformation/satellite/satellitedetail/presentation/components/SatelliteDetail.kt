package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.UIConstants.SATELLITE_DETAIL_SCREEN_BACK_ICON
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.UIConstants.SATELLITE_DETAIL_SCREEN_CLOSE_ICON
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.UIConstants.SATELLITE_DETAIL_SCREEN_SEPARATOR
import com.eniskaner.eyojsatellitesinformation.core.presentation.Gray600
import com.eniskaner.eyojsatellitesinformation.core.presentation.UiText
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel
import eyojsatellitesinformationc.composeapp.generated.resources.Res
import eyojsatellitesinformationc.composeapp.generated.resources.cost
import eyojsatellitesinformationc.composeapp.generated.resources.height_and_mass
import eyojsatellitesinformationc.composeapp.generated.resources.height_mass_placeholder
import eyojsatellitesinformationc.composeapp.generated.resources.last_position
import org.jetbrains.compose.resources.stringResource

@Composable
fun SatelliteDetail(
    satelliteDetail: SatelliteDetailUIModel
) {
    Text(
        text = satelliteDetail.name,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Gray600
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = satelliteDetail.firstFlight,
        color = Gray600
    )
    Spacer(modifier = Modifier.height(32.dp))
    Row {
        Text(
            text = stringResource(Res.string.height_and_mass),
            fontWeight = FontWeight.Bold,
            color = Gray600
        )
        Text(
            text = UiText.StringResourceId(
                id = Res.string.height_mass_placeholder,
                args = arrayOf(
                    satelliteDetail.height,
                    satelliteDetail.mass
                )
            ).asString(),
            color = Gray600
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row {
        Text(
            text = stringResource(Res.string.cost),
            fontWeight = FontWeight.Bold,
            color = Gray600
        )
        Text(
            text = satelliteDetail.costPerLaunch.toString(),
            color = Gray600
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row {
        Text(
            text = stringResource(Res.string.last_position),
            fontWeight = FontWeight.Bold,
            color = Gray600
        )

        Text(
            text = SATELLITE_DETAIL_SCREEN_BACK_ICON.plus(satelliteDetail.posX.toString())
                .plus(SATELLITE_DETAIL_SCREEN_SEPARATOR)
                .plus(satelliteDetail.posY.toString()).plus(SATELLITE_DETAIL_SCREEN_CLOSE_ICON),
            color = Gray600
        )
    }
}