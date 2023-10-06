package com.feature.movie.ui.navigation.screen

import androidx.lifecycle.ViewModel
import com.feature.movie.domain.use_cases.GetYGOListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class YGOCardSearchViewModel @Inject constructor(
    private val getAllYGOListUseCase:GetYGOListUseCase
)
    : ViewModel() {

}