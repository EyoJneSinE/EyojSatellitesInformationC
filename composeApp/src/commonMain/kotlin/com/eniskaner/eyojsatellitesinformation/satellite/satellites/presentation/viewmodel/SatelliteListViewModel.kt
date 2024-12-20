package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.Delays.DEFAULT_DELAY
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.ErrorMessages.DEFAULT_ERROR_MESSAGE
import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase.GetSatelliteListUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.usecase.GetSearchSatelliteListUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListAction
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.SatelliteListUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SatelliteListViewModel(
    private val satelliteListUseCase: GetSatelliteListUseCase,
    private val searchSatelliteListUseCase: GetSearchSatelliteListUseCase
) : ViewModel() {

    private val _satelliteListUIState = MutableStateFlow(SatelliteListUIState())
    val satelliteListUIState = _satelliteListUIState.asStateFlow()

    init {
        getSatelliteList()
        searchSatellite(query = _satelliteListUIState.value.query)
    }

    private fun getSatelliteList() {
        viewModelScope.launch {
            satelliteListUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _satelliteListUIState.update {
                            it.copy(
                                satelliteList = resource.data ?: emptyList(),
                                searchingSatelliteList = resource.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Error -> {
                        _satelliteListUIState.update {
                            it.copy(
                                error = resource.message ?: DEFAULT_ERROR_MESSAGE,
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _satelliteListUIState.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                        delay(DEFAULT_DELAY)
                    }
                }
            }
        }
    }

    private fun searchSatellite(query: String) {
        viewModelScope.launch {
            searchSatelliteListUseCase.invoke(query = query).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _satelliteListUIState.update {
                            it.copy(
                                searchingSatelliteList = resource.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Error -> {
                        _satelliteListUIState.update {
                            it.copy(
                                error = resource.message ?: DEFAULT_ERROR_MESSAGE,
                                isLoading = false
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _satelliteListUIState.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                        delay(DEFAULT_DELAY)
                    }
                }
            }
        }
    }

    fun onSatelliteAction(action: SatelliteListAction) {
        when (action) {
            is SatelliteListAction.OnSearchQueryChange -> {
                _satelliteListUIState.update {
                    it.copy(query = action.query)
                }
                searchSatellite(query = action.query)
            }

            is SatelliteListAction.OnSatelliteClick -> {
                // Navigate to satellite detail screen
            }
        }
    }
}
