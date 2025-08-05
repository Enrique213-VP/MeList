package com.svape.melist.di

import android.content.Context
import androidx.room.Room
import com.svape.melist.data.repository.SearchHistoryRepositoryImpl
import com.svape.melist.domain.repository.SearchHistoryRepository
import com.svape.melist.data.local.dao.SearchHistoryDao
import com.svape.melist.data.local.database.MercadoLibreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideMercadoLibreDatabase(
        @ApplicationContext context: Context
    ): MercadoLibreDatabase {
        return Room.databaseBuilder(
            context,
            MercadoLibreDatabase::class.java,
            "mercadolibre.db"
        ).build()
    }

    @Provides
    fun provideSearchHistoryDao(
        database: MercadoLibreDatabase
    ): SearchHistoryDao = database.searchHistoryDao

    @Provides
    fun provideSearchHistoryRepository(
        searchHistoryDao: SearchHistoryDao
    ): SearchHistoryRepository = SearchHistoryRepositoryImpl(searchHistoryDao)
}
