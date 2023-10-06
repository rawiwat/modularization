package com.core.network.dependency_injection

import com.core.network.ApiService
import com.core.network.dataproviders.YGODataProviders
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService():ApiService = Retrofit
        .Builder()
        .baseUrl("https://db.ygoprodeck.com/api/v7/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)

    @Provides
    fun provideYGODataProvider(apiService: ApiService):YGODataProviders{
        return YGODataProviders(apiService)
    }
}