package com.eniskaner.eyojsatellitesinformation.app

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.eniskaner.eyojsatellitesinformation.core.presentation.LightGray
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.SatelliteDetailAction
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.SatelliteDetailScreenRoot
import com.eniskaner.eyojsatellitesinformation.satellite.satellitedetail.presentation.viewmodel.SatelliteDetailViewModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.SatelliteListScreenRoot
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SatelliteListViewModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SelectedSatelliteViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGray)
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Route.SatelliteGraph
            ) {
                navigation<Route.SatelliteGraph>(
                    startDestination = Route.SatelliteList
                ) {
                    composable<Route.SatelliteList>(
                        exitTransition = { slideOutHorizontally() },
                        popEnterTransition = { slideInHorizontally() }
                    ) {
                        val viewModel = koinViewModel<SatelliteListViewModel>()
                        val selectedSatelliteViewModel =
                            it.sharedKoinViewModel<SelectedSatelliteViewModel>(navController)

                        LaunchedEffect(true) {
                            selectedSatelliteViewModel.onSelectedSatellite(null)
                        }

                        SatelliteListScreenRoot(
                            viewModel = viewModel,
                            onSatelliteClick = { satellite ->
                                navController.navigate(
                                    Route.SatelliteDetail(
                                        id = satellite.id,
                                        name = satellite.name
                                    )
                                )
                            }
                        )
                    }
                    composable<Route.SatelliteDetail>(
                        enterTransition = {
                            slideInHorizontally { initialOffset ->
                                initialOffset
                            }
                        },
                        exitTransition = {
                            slideOutHorizontally { initialOffset ->
                                initialOffset
                            }
                        }
                    ) {
                        val selectedSatelliteViewModel =
                            it.sharedKoinViewModel<SelectedSatelliteViewModel>(navController)
                        val viewModel = koinViewModel<SatelliteDetailViewModel>()

                        val selectedSatellite by selectedSatelliteViewModel.selectedSatellite.collectAsStateWithLifecycle()

                        LaunchedEffect(selectedSatellite) {
                            selectedSatellite?.let { satellite ->
                                viewModel.onAction(SatelliteDetailAction.OnSelectedSatellite(satellite))
                            }
                        }

                        SatelliteDetailScreenRoot(
                            viewModel = viewModel,
                            onBackClick = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private inline fun <reified T : ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}
