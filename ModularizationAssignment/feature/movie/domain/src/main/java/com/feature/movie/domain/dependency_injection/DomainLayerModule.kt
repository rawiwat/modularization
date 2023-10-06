package com.feature.movie.domain.dependency_injection

import com.feature.movie.domain.repo.YGORepository
import com.feature.movie.domain.use_cases.GetYGOListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainLayerModule {
    @Provides
    fun provideGetAllYGOCardUseCase(ygoRepository: YGORepository):GetYGOListUseCase{
        return GetYGOListUseCase(ygoRepository)
    }
}