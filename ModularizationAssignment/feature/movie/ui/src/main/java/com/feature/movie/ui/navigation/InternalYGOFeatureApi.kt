package com.feature.movie.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constant.YGOFeature
import com.core.feature_api.FeatureApi
import com.feature.movie.ui.navigation.screen.YGOCardScreen
import com.feature.movie.ui.navigation.screen.YGOCardSearchViewModel

internal object InternalYGOFeatureApi: FeatureApi {
    override fun registerGraph(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = YGOFeature.ygoScreenRoute,
            route = YGOFeature.nestedRoute
        ) {
            composable(YGOFeature.ygoScreenRoute) {
                val viewModel = hiltViewModel<YGOCardSearchViewModel>()
                YGOCardScreen(viewModel = viewModel)
            }
        }
    }
}