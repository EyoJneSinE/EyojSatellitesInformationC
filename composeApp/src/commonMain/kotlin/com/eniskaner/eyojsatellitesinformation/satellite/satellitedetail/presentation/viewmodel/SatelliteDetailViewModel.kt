package com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.eniskaner.eyojsatellitesinformation.app.Route
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.Delays.DEFAULT_DELAY
import com.eniskaner.eyojsatellitesinformation.core.data.Constants.ErrorMessages.DEFAULT_ERROR_MESSAGE
import com.eniskaner.eyojsatellitesinformation.core.presentation.Resource
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase.GetSatelliteDetailUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.domain.usecase.GetSatellitePositionUseCase
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.SatelliteDetailAction
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.model.SatelliteDetailUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.state.SatelliteDetailState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SatelliteDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val getSatelliteDetailUseCase: GetSatelliteDetailUseCase,
    private val getSatellitePositionUseCase: GetSatellitePositionUseCase
) : ViewModel() {

    private val satelliteId = savedStateHandle.toRoute<Route.SatelliteDetail>().id
    private val satelliteName = savedStateHandle.toRoute<Route.SatelliteDetail>().name

    private val _satelliteDetail = MutableStateFlow(SatelliteDetailState())
    val satelliteDetail = _satelliteDetail.asStateFlow()

    init {
        getSatelliteDetail(satelliteId = satelliteId, satelliteName = satelliteName)
    }

    fun onAction(action: SatelliteDetailAction) {
        when (action) {
            is SatelliteDetailAction.OnSelectedSatellite -> {
                _satelliteDetail.update {
                    it.copy(
                        satelliteDetail = action.satelliteDetailUIModel
                    )
                }
            }

            else -> Unit
        }
    }

    private fun getSatelliteDetail(satelliteId: Int, satelliteName: String) {
        viewModelScope.launch {
            val satelliteDetailResult = getSatelliteDetailUseCase.invoke(id = satelliteId)
            val satellitePositionResult = getSatellitePositionUseCase.invoke(id = satelliteId)

            satelliteDetailResult.combine(satellitePositionResult) { detailResource, positionResource ->
                when {
                    detailResource is Resource.Success && positionResource is Resource.Success -> {
                        val satelliteDetail = detailResource.data
                        val satellitePosition = positionResource.data
                        if (satelliteDetail != null && satellitePosition != null) {
                            _satelliteDetail.update {
                                it.copy(
                                    satelliteDetail = SatelliteDetailUIModel(
                                        id = satelliteDetail.id,
                                        costPerLaunch = satelliteDetail.costPerLaunch,
                                        firstFlight = satelliteDetail.firstFlight,
                                        height = satelliteDetail.height,
                                        mass = satelliteDetail.mass,
                                        posX = satellitePosition.posX,
                                        posY = satellitePosition.posY,
                                        name = satelliteName
                                    ),
                                    isLoading = false
                                )
                            }
                        }
                    }

                    detailResource is Resource.Error -> {
                        _satelliteDetail.update {
                            it.copy(
                                error = detailResource.message ?: DEFAULT_ERROR_MESSAGE,
                                isLoading = false
                            )
                        }
                    }

                    positionResource is Resource.Error -> {
                        _satelliteDetail.update {
                            it.copy(
                                error = detailResource.message ?: DEFAULT_ERROR_MESSAGE,
                                isLoading = false
                            )
                        }
                    }

                    detailResource is Resource.Loading || positionResource is Resource.Loading -> {
                        _satelliteDetail.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                        delay(DEFAULT_DELAY)
                    }
                }
            }.collect {}
        }
    }
}
