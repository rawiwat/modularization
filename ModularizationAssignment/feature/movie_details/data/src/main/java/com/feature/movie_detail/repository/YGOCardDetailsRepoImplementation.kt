package com.feature.movie_detail.repository

import com.core.network.dataproviders.YGODataProviders
import com.feature.movie_detail.mappers.simplified
import com.feature.movie_detials.domain.SimpleYGOCardDetail
import com.feature.movie_detials.domain.repository.YGOCardDetailsRepository
import javax.inject.Inject

class YGOCardDetailsRepoImplementation @Inject constructor(
    private val ygoDataProviders : YGODataProviders
):YGOCardDetailsRepository {
    override suspend fun getYGOCardDetail(id: String): SimpleYGOCardDetail {
        return ygoDataProviders.getYGOCardDetail(id).simplified()
    }
}