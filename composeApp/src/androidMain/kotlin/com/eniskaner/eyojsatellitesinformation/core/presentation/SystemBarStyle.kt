package com.eniskaner.eyojsatellitesinformation.core.presentation

actual class SystemBarStyle actual constructor(
    actual val isLight: Boolean,
    actual val scrimColor: Int
) {
    companion object {
        fun auto(lightScrim: Int, darkScrim: Int): SystemBarStyle {
            val isLightTheme = true
            return if (isLightTheme) {
                SystemBarStyle(isLight = true, scrimColor = lightScrim)
            } else {
                SystemBarStyle(isLight = false, scrimColor = darkScrim)
            }
        }
    }
}
