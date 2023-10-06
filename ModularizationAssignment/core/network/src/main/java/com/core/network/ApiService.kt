package com.core.network

import com.core.network.model.YGOCards
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //full url
    //https://db.ygoprodeck.com/api/v7/cardinfo.php

    @GET("cardinfo.php")
    suspend fun getYGOCards(
        @Query("fname") name: String
    ):YGOCards
}