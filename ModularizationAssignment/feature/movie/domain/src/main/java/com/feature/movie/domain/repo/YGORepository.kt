package com.feature.movie.domain.repo

import com.feature.movie.domain.model.YGOCardImage

interface YGORepository {
    suspend fun getAllYGOCards() : List<YGOCardImage>
}