package com.example.modularization.navigation

import com.example.movie_details.ui.navigation.YGOCardDetailApi
import com.feature.movie.ui.navigation.YGOApi

data class NavigationProvider(
    val ygoApi:YGOApi,
    val ygoCardDetailApi: YGOCardDetailApi
)
