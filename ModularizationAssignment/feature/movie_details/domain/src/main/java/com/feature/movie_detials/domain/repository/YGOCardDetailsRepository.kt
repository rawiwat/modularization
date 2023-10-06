package com.feature.movie_detials.domain.repository

import com.feature.movie_detials.domain.SimpleYGOCardDetail

interface YGOCardDetailsRepository {
    suspend fun getYGOCardDetail(id:String) : SimpleYGOCardDetail
}