package com.feature.movie.data.dependency_injection

import com.core.network.dataproviders.YGODataProviders
import com.feature.movie.data.repository.YGORepositoryImplementation
import com.feature.movie.domain.repo.YGORepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
object DataLayerModule {
    @Provides
    fun provideYGORepo(ygoDataProviders: YGODataProviders):YGORepository {
        return  YGORepositoryImplementation(ygoDataProviders)
    }
}