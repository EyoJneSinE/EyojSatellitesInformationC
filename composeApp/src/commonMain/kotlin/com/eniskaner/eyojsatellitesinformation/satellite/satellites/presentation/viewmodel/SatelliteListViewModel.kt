package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListAction
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.SatelliteListUIState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SatelliteListViewModel: ViewModel() {

    private val _satelliteListUIState = MutableStateFlow(SatelliteListUIState())
    val satelliteListUIState = _satelliteListUIState.asStateFlow()

    fun onSatelliteAction(action: SatelliteListAction) {
        when (action) {
            is SatelliteListAction.OnSearchQueryChange -> {
                _satelliteListUIState.update {
                    it.copy(query = action.query)
                }
            }
            is SatelliteListAction.OnSatelliteClick -> {
                // Navigate to satellite detail screen
            }
        }
    }

    private fun observeSearchQuery() {
        _satelliteListUIState
            .map { it.query }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isBlank() -> {
                        _satelliteListUIState.update {
                            it.copy(
                                error = null,
                                searchingSatelliteList = emptyList()
                            )
                        }
                    }
                    query.length >= 2 -> {
                        _satelliteListUIState.update {
                            it.copy(
                                error = null,
                                searchingSatelliteList = it.satelliteList.filter { satellite->
                                    satellite.name
                                        .trim()
                                        .lowercase()
                                        .contains(query.trim().lowercase(), ignoreCase = true)
                                }
                            )
                        }
                    }
                }
            }
    }

    private fun searchSatellites(query: String) = viewModelScope.launch {
        _satelliteListUIState.update {
            it.copy(isLoading = true)
        }

    }
}