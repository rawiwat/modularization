package com.feature.movie_detials.domain.dependency_injection

import com.feature.movie_detials.domain.repository.YGOCardDetailsRepository
import com.feature.movie_detials.domain.use_cases.GetYGOCardDetailUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
object UiModule {
    @Provides
    fun provideGetYGOCardDetailUseCase(ygoCardDetailsRepository: YGOCardDetailsRepository):GetYGOCardDetailUseCase {
        return GetYGOCardDetailUseCase(ygoCardDetailsRepository)
    }
}