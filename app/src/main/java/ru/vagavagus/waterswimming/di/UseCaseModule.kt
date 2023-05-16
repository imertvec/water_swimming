package ru.vagavagus.waterswimming.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vagavagus.waterswimming.domain.repository.ChampionshipRepository
import ru.vagavagus.waterswimming.domain.repository.MedalRepository
import ru.vagavagus.waterswimming.domain.use_case.FetchChampionships
import ru.vagavagus.waterswimming.domain.use_case.FetchMedalList
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchChampionship(repository: ChampionshipRepository): FetchChampionships {
        return FetchChampionships(repository)
    }

    @Provides
    @Singleton
    fun provideFetchMedalList(repository: MedalRepository): FetchMedalList {
        return FetchMedalList(repository)
    }
}