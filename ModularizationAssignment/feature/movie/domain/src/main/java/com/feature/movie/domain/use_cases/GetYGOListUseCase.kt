package com.feature.movie.domain.use_cases

import com.core.common.UiEvent
import com.feature.movie.domain.model.YGOCardImage
import com.feature.movie.domain.repo.YGORepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetYGOListUseCase @Inject constructor(
    private val ygoRepository: YGORepository
) {
    operator fun invoke() = flow<UiEvent<List<YGOCardImage>>> {}
}