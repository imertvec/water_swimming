package ru.vagavagus.waterswimming.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.vagavagus.waterswimming.common.Constants
import ru.vagavagus.waterswimming.data.remote.MedalApi
import ru.vagavagus.waterswimming.data.repository.ChampionshipRepositoryImpl
import ru.vagavagus.waterswimming.data.repository.MedalRepositoryImpl
import ru.vagavagus.waterswimming.data.room.AppDatabase
import ru.vagavagus.waterswimming.domain.repository.ChampionshipRepository
import ru.vagavagus.waterswimming.domain.repository.MedalRepository
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
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): MedalApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MedalApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChampionshipRepository(
        database: AppDatabase
    ): ChampionshipRepository {
        return ChampionshipRepositoryImpl(
            championshipDao = database.championshipDao,
            locationDao = database.locationDao,
            countryDao = database.countryDao
        )
    }

    @Provides
    @Singleton
    fun provideMedalRepository(
        api: MedalApi
    ): MedalRepository {
        return MedalRepositoryImpl(api)
    }
}