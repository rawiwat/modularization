package com.feature.movie.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.core.feature_api.FeatureApi

interface YGOApi : FeatureApi {
}

class YGOApiImplementation : YGOApi {
    override fun registerGraph(navController: NavController, navGraphBuilder: NavGraphBuilder) {
        InternalYGOFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }
}