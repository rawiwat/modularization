package com.feature.movie.ui.navigation.screen

import com.feature.movie.domain.model.YGOCardImage

data class YGOCardSearchStateHolder(
    val isLoading: Boolean = false,
    val data: List<YGOCardImage>? = null,
    val errorMessage: String = ""
)
