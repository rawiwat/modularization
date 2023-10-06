package com.feature.movie_detail.dependency_injection

import com.core.network.dataproviders.YGODataProviders
import com.feature.movie_detail.repository.YGOCardDetailsRepoImplementation
import com.feature.movie_detials.domain.repository.YGOCardDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideYGOCardDetailRepo(ygoDataProviders: YGODataProviders):YGOCardDetailsRepository {
        return YGOCardDetailsRepoImplementation(ygoDataProviders)
    }

}