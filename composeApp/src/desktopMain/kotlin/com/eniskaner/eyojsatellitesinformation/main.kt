package com.eniskaner.eyojsatellitesinformation

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.eniskaner.eyojsatellitesinformation.app.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EyojSatellitesInformationC",
    ) {
        App()
    }
}