package com.example.movie_details.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.core.common.navigation_constant.YGOCardDetailFeature
import com.core.feature_api.FeatureApi
import com.example.movie_details.ui.screen.YGOCardDetailScreen
import com.example.movie_details.ui.screen.YGOCardDetailViewModel

object InternalYGODetailApi : FeatureApi {
    override fun registerGraph(
        navController: androidx.navigation.NavController,
        navGraphBuilder: androidx.navigation.NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            route = YGOCardDetailFeature.nestedRoute,
            startDestination = YGOCardDetailFeature.ygoDetailScreenRoute,
        ) {
            composable(
                route = YGOCardDetailFeature.ygoDetailScreenRoute,
                arguments = listOf(
                    navArgument(name = "id") {
                        type = NavType.StringType
                    }
                )
            ) {
                val id = it.arguments!!.getString("id")
                val viewModel = hiltViewModel<YGOCardDetailViewModel>()
                if (id != null) {
                    YGOCardDetailScreen(id = id,viewModel)
                }
            }
        }
    }
}