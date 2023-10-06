package com.example.movie_details.ui.dependency_injection

import com.example.movie_details.ui.navigation.YGOCardDetailApi
import com.example.movie_details.ui.navigation.YGOCardDetailApiImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideYGOCardDetailApi():YGOCardDetailApi {
        return YGOCardDetailApiImplementation()
    }
}