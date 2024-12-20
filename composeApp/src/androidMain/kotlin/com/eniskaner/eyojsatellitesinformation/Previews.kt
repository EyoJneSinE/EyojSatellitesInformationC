package com.eniskaner.eyojsatellitesinformation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.SatelliteDetailScreen
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.state.SatelliteDetailState
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListScreen
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components.SatelliteSearchBar
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.SatelliteListUIState

@Preview
@Composable
private fun SatelliteSearchBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        SatelliteSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

val satellites = (1..40).map {
    SatelliteUIModel(
        id = it,
        isActive = false,
        name = "Starship-1"
    )
}


@Preview
@Composable
private fun SatelliteListScreenPreview() {
    SatelliteListScreen(
        state = SatelliteListUIState(
            searchingSatelliteList = satellites
        ),
        onAction = {}
    )
}

@Preview
@Composable
private fun SatelliteDetailScreenPreview() {
    val mock = SatelliteDetailUIModel(
        id = 1,
        name = "Starship - 1",
        costPerLaunch = 8300000L,
        firstFlight = "2020-10-03",
        height = 110,
        mass = 1135000,
        posX = 0.213733842,
        posY = 0.239480213
    )
    SatelliteDetailScreen(
        state = SatelliteDetailState(
            satelliteDetail = mock
        ),
        onAction = {}
    )
}