package com.eniskaner.eyojsatellitesinformation.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListScreenRoot
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SatelliteListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    SatelliteListScreenRoot(
        viewModel = remember { SatelliteListViewModel() },
        onSatelliteClick = {}
    )
}