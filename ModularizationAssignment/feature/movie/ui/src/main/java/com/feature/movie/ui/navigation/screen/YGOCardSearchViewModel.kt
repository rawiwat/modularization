package com.feature.movie.ui.navigation.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetYGOListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YGOCardSearchViewModel @Inject constructor(
    private val getAllYGOListUseCase:GetYGOListUseCase
) : ViewModel() {
    private val _ygoCardList = mutableStateOf(YGOCardSearchStateHolder())
    val ygoCardList: State<YGOCardSearchStateHolder> get() = _ygoCardList

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    fun getYgoCardList(name: String) = viewModelScope.launch {
        getAllYGOListUseCase(name).onEach {
            when(it) {
                is UiEvent.Loading-> {
                    _ygoCardList.value = YGOCardSearchStateHolder(isLoading = true)
                }
                is UiEvent.Error -> {
                    _ygoCardList.value = YGOCardSearchStateHolder(errorMessage = it.message.toString())
                }
                is UiEvent.Success -> {
                    _ygoCardList.value = YGOCardSearchStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun setQuery(input:String) {
        _query.value = input
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getYgoCardList(it)
            }
        }
    }
}