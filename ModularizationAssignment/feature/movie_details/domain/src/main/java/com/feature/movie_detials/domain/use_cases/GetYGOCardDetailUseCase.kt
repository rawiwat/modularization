package com.feature.movie_detials.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie_detials.domain.SimpleYGOCardDetail
import com.feature.movie_detials.domain.repository.YGOCardDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetYGOCardDetailUseCase @Inject constructor(
    private val ygoCardDetailsRepository: YGOCardDetailsRepository
) {
    operator fun invoke(id: String): Flow<UiEvent<SimpleYGOCardDetail>> = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(data = ygoCardDetailsRepository.getYGOCardDetail(id)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}