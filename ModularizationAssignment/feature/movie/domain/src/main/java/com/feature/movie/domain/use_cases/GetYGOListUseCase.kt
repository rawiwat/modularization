package com.feature.movie.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie.domain.model.YGOCardImage
import com.feature.movie.domain.repo.YGORepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetYGOListUseCase @Inject constructor(
    private val ygoRepository: YGORepository
) {
    operator fun invoke(name: String) = flow<UiEvent<List<YGOCardImage>>> {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(ygoRepository.getYGOCards(name = name)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}