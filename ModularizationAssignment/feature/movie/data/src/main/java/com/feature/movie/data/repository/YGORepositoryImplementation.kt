package com.feature.movie.data.repository

import com.core.network.dataproviders.YGODataProviders
import com.feature.movie.data.mapper.toYGOCardImage
import com.feature.movie.domain.model.YGOCardImage
import com.feature.movie.domain.repo.YGORepository
import javax.inject.Inject

class YGORepositoryImplementation @Inject constructor(
    private val ygoDataProviders: YGODataProviders
)
    : YGORepository {
    override suspend fun getAllYGOCards(): List<YGOCardImage> {
        return ygoDataProviders.getAllYGOCards().toYGOCardImage()
    }
}