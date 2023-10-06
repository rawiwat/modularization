package com.feature.movie.domain.repo

import com.feature.movie.domain.model.YGOCardImage

interface YGORepository {
    suspend fun getYGOCards(name:String) : List<YGOCardImage>
}