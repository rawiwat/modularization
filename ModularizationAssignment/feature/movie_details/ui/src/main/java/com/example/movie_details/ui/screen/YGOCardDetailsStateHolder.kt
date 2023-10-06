package com.example.movie_details.ui.screen

import com.feature.movie_detials.domain.SimpleYGOCardDetail

data class YGOCardDetailsStateHolder(
    val isLoading:Boolean = false,
    val error:String = "",
    val data:SimpleYGOCardDetail? = null
)
