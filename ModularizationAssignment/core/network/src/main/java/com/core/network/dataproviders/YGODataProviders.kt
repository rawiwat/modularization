package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

class YGODataProviders @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllYGOCards() = apiService.getAllYGOCard()
}