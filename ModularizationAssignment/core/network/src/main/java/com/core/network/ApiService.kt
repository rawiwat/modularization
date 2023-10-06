package com.core.network

import com.core.network.model.YGOCards
import retrofit2.http.GET

interface ApiService {

    //full url
    //https://db.ygoprodeck.com/api/v7/cardinfo.php

    @GET("cardinfo.php")
    suspend fun getAllYGOCard():YGOCards
}