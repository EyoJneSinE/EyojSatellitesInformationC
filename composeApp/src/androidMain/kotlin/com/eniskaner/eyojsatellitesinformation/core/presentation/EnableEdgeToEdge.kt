package com.eniskaner.eyojsatellitesinformation.core.presentation

import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

actual fun enableEdgeToEdge(
    windowHandle: Any,
    statusBarStyle: SystemBarStyle,
    navigationBarStyle: SystemBarStyle
) {
    val window = (windowHandle as? ComponentActivity)?.window
        ?: throw IllegalArgumentException("Invalid window handle")

    val insetsController = WindowCompat.getInsetsController(window, window.decorView)
    insetsController.apply {
        hide(WindowInsetsCompat.Type.systemBars())
        systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}
