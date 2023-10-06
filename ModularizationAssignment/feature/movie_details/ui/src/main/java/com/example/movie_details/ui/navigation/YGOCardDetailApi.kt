package com.example.movie_details.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.core.feature_api.FeatureApi

interface YGOCardDetailApi :FeatureApi {
}
class YGOCardDetailApiImplementation : YGOCardDetailApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalYGODetailApi.registerGraph(navController,navGraphBuilder)
    }
}