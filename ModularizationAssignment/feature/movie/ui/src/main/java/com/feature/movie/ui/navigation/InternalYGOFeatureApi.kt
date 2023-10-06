package com.feature.movie.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.feature_api.FeatureApi

object InternalYGOFeatureApi: FeatureApi {
    override fun registerGraph(
        navController: NavController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = "home",
            route = "ygo_nested_navigation"
        ) {
            composable("home") {
            }
        }
    }
}