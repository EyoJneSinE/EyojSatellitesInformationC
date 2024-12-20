package com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eniskaner.eyojsatellitesinformation.core.presentation.LightGray
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.domain.model.SatelliteUIModel
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components.SatelliteList
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.components.SatelliteSearchBar
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.state.SatelliteListUIState
import com.eniskaner.eyojsatellitesinformation.satellite.satellites.presentation.viewmodel.SatelliteListViewModel
import eyojsatellitesinformationc.composeapp.generated.resources.Res
import eyojsatellitesinformationc.composeapp.generated.resources.no_search_results
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SatelliteListScreenRoot(
    viewModel: SatelliteListViewModel = koinViewModel(),
    onSatelliteClick: (SatelliteUIModel) -> Unit,
) {
    val state by viewModel.satelliteListUIState.collectAsStateWithLifecycle()

    SatelliteListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is SatelliteListAction.OnSatelliteClick -> onSatelliteClick(action.satellite)
                else -> Unit
            }
            viewModel.onSatelliteAction(action = action)
        }
    )

}

@Composable
fun SatelliteListScreen(
    state: SatelliteListUIState,
    onAction: (SatelliteListAction) -> Unit,
) {

    val keyBoardController = LocalSoftwareKeyboardController.current

    val searchResultsListState = rememberLazyListState()

    LaunchedEffect(state.searchingSatelliteList) {
        searchResultsListState.animateScrollToItem(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray)
            .statusBarsPadding()
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SatelliteSearchBar(
            searchQuery = state.query,
            onSearchQueryChange = {
                onAction(SatelliteListAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyBoardController?.hide()
            },
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 40.dp)
        )

        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            color = LightGray,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator()
                    } else {
                        when {
                            state.error != null -> {
                                Text(
                                    text = state.error,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }

                            state.searchingSatelliteList.isEmpty() && state.query.isNotEmpty() -> {
                                Text(
                                    text = stringResource(Res.string.no_search_results),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }

                            else -> {
                                SatelliteList(
                                    satellites = state.searchingSatelliteList,
                                    onItemClick = {
                                        onAction(SatelliteListAction.OnSatelliteClick(it))
                                    },
                                    modifier = Modifier.fillMaxSize(),
                                    scrollState = searchResultsListState
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
