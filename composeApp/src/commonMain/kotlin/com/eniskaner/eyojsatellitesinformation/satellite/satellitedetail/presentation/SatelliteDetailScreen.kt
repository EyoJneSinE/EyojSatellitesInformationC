package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eniskaner.eyojsatellitesinformation.core.presentation.LightGray
import com.eniskaner.eyojsatellitesinformation.core.presentation.handleBackPress
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.components.SatelliteDetail
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.state.SatelliteDetailState
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.viewmodel.SatelliteDetailViewModel

@Composable
fun SatelliteDetailScreenRoot(
    viewModel: SatelliteDetailViewModel,
    onBackClick: () -> Unit,
) {

    handleBackPress(onBackClick)

    val satelliteDetailState by viewModel.satelliteDetail.collectAsStateWithLifecycle()

    SatelliteDetailScreen(
        state = satelliteDetailState,
        onAction = {}
    )

}

@Composable
fun SatelliteDetailScreen(
    state: SatelliteDetailState,
    onAction: (SatelliteDetailAction) -> Unit,
) {
    if (state.satelliteDetail != null) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                when {
                    state.error != null -> {
                        Text(
                            text = state.error,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    else -> {
                        SatelliteDetail(satelliteDetail = state.satelliteDetail)
                    }
                }
            }
        }
    }
}
