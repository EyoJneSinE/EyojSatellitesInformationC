package com.eniskaner.eyojsatellitesinformation.core.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun handleBackPress(onBackPress: () -> Unit) {
    BackHandler {
        onBackPress()
    }
}
