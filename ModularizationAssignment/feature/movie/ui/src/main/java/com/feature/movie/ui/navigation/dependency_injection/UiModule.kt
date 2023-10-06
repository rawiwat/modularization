package com.feature.movie.ui.navigation.dependency_injection

import com.feature.movie.ui.navigation.YGOApi
import com.feature.movie.ui.navigation.YGOApiImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun provideYGOApi():YGOApi {
        return YGOApiImplementation()
    }
}