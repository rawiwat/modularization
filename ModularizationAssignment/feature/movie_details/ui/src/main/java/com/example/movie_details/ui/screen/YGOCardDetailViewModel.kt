package com.example.movie_details.ui.screen

import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_detials.domain.use_cases.GetYGOCardDetailUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class YGOCardDetailViewModel @Inject constructor(
  private val getYGOCardDetailUseCase: GetYGOCardDetailUseCase,
  savedStateHandle: SavedStateHandle
):ViewModel() {
  private val _ygoCardDetail = mutableStateOf(YGOCardDetailsStateHolder())
  val ygoCardDetail: State<YGOCardDetailsStateHolder> get() = _ygoCardDetail

  fun getYGOCardDetails(id:String) {
    getYGOCardDetailUseCase(id).onEach {
      when(it) {
        is UiEvent.Loading-> {
          _ygoCardDetail.value = YGOCardDetailsStateHolder(isLoading = true)
        }
        is UiEvent.Error -> {
          _ygoCardDetail.value = YGOCardDetailsStateHolder(error = it.message.toString())
        }
        is UiEvent.Success -> {
          _ygoCardDetail.value = YGOCardDetailsStateHolder(data = it.data)
        }
      }
    }.launchIn(viewModelScope)
  }

  init {
    savedStateHandle.getLiveData<String>("id").observeForever {
      it?.let {
        getYGOCardDetails(it)
      }
    }
  }
}