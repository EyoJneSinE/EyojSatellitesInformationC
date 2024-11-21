package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.eniskaner.eyojsatellitesinformation.core.presentation.ActiveGreen
import com.eniskaner.eyojsatellitesinformation.core.presentation.Gray400
import com.eniskaner.eyojsatellitesinformation.core.presentation.Gray600
import com.eniskaner.eyojsatellitesinformation.core.presentation.InactiveRed
import com.eniskaner.eyojsatellitesinformation.core.presentation.LightBlue
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.SatelliteUIModel
import eyojsatellitesinformationc.composeapp.generated.resources.Res
import eyojsatellitesinformationc.composeapp.generated.resources.active_status
import eyojsatellitesinformationc.composeapp.generated.resources.ic_indicator
import eyojsatellitesinformationc.composeapp.generated.resources.passive_status
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun SatelliteListItem(
    satellite: SatelliteUIModel,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLast: Boolean
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onItemClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_indicator),
                tint = if (satellite.isActive) ActiveGreen else InactiveRed.copy(alpha = 0.4f),
                contentDescription = "Satellite status icon"
            )

            Spacer(modifier = Modifier.width(24.dp))

            Column(
                modifier = Modifier.fillMaxWidth(0.3f)
            ) {
                val textTitleColor = if (satellite.isActive) Gray600 else Gray600.copy(alpha = 0.5f)
                val textStatusColor = if (satellite.isActive) Gray400 else Gray400.copy(alpha = 0.5f)
                Text(
                    text = satellite.name,
                    color = textTitleColor,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if(satellite.isActive) stringResource(Res.string.active_status) else stringResource(Res.string.passive_status),
                    color = textStatusColor
                )
                MaterialTheme.typography.bodyLarge
            }
        }
        if(!isLast)
            HorizontalDivider(modifier = Modifier
                .padding(top = 8.dp)
                .background(color = Gray400))

        if (isLast)
            Spacer(modifier = Modifier.height(16.dp))
    }
}

