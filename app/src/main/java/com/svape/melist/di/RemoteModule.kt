package com.svape.melist.di

import android.content.Context
import com.svape.melist.domain.datasource.RemoteDataSource
import com.svape.melist.data.remote.ApiServiceImp
import com.svape.melist.data.remote.datasource.RemoteDataSourceImpl
import com.svape.melist.data.remote.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideApiService(@ApplicationContext context: Context): ApiService {
        return ApiServiceImp(context)
    }

    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}