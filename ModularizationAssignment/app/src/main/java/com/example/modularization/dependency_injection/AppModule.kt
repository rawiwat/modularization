package com.example.modularization.dependency_injection

import com.example.modularization.navigation.NavigationProvider
import com.feature.movie.ui.navigation.YGOApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigatorProvider(ygoApi: YGOApi):NavigationProvider {
        return NavigationProvider(ygoApi)
    }
}