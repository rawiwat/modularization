package com.core.network

import com.core.network.model.YGOCardDetails
import com.core.network.model.YGOCards
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //full url
    //https://db.ygoprodeck.com/api/v7/cardinfo.php?fname=

    @GET("cardinfo.php")
    suspend fun getYGOCards(
        @Query("fname") name: String
    ): YGOCards

    //https://db.ygoprodeck.com/api/v7/cardinfo.php?id=6850209
    @GET("cardinfo.php")
    suspend fun getYGOCardDetails(
        @Query("id") id: String
    ): YGOCardDetails

}