package ru.vagavagus.waterswimming.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vagavagus.waterswimming.data.repository.ChampionshipRepositoryImpl
import ru.vagavagus.waterswimming.data.room.AppDatabase
import ru.vagavagus.waterswimming.domain.repository.ChampionshipRepository
import ru.vagavagus.waterswimming.domain.use_case.FetchChampionships
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .createFromAsset("database/app_database.db")
            .build()
    }


    @Provides
    @Singleton
    fun provideChampionshipRepository(
        database: AppDatabase
    ): ChampionshipRepository {
        return ChampionshipRepositoryImpl(
            database.championshipDao,
            database.locationDao,
            database.countryDao
        )
    }

    @Provides
    @Singleton
    fun provideFetchChampionship(repository: ChampionshipRepository): FetchChampionships {
        return FetchChampionships(repository)
    }
}