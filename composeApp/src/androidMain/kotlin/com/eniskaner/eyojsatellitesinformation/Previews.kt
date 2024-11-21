package com.eniskaner.eyojsatellitesinformation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.SatelliteUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListScreen
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components.SatelliteListItem
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components.SatelliteSearchBar
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.SatelliteListUIState
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.satellites

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