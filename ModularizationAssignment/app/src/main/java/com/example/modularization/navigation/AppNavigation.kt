package com.example.modularization.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constant.YGOFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(
        navController = navController,
        startDestination = YGOFeature.nestedRoute
    ) {
        navigationProvider.ygoApi.registerGraph(
            navController,this
        )
        navigationProvider.ygoCardDetailApi.registerGraph(
            navController,this
        )
    }
}