package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.SatelliteUIModel

@Composable
fun SatelliteList(
    satellites: List<SatelliteUIModel>,
    onItemClick: (SatelliteUIModel) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        modifier = modifier,
        state = scrollState,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = satellites,
            key = { it.id }
        ) { satellite ->
            SatelliteListItem(
                satellite = satellite,
                modifier = Modifier
                    .widthIn(max = 700.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onItemClick = {
                    onItemClick(satellite)
                },
                isLast = satellites.last() == satellite
            )
        }
    }

}