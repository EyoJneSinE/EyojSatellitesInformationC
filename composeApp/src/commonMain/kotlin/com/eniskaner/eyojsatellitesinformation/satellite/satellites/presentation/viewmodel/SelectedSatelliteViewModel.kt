package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedSatelliteViewModel : ViewModel() {

    private val _selectedSatellite = MutableStateFlow<SatelliteDetailUIModel?>(null)
    val selectedSatellite = _selectedSatellite.asStateFlow()

    fun onSelectedSatellite(satellite: SatelliteDetailUIModel?) {
        _selectedSatellite.value = satellite
    }
}
