package com.svape.melist.di

import com.svape.melist.data.repository.ProductRepositoryImpl
import com.svape.melist.domain.repository.ProductRepository
import com.svape.melist.domain.datasource.RemoteDataSource
import com.svape.melist.domain.repository.SearchHistoryRepository
import com.svape.melist.domain.usecase.GetProductCategoryUseCase
import com.svape.melist.domain.usecase.GetProductDescriptionUseCase
import com.svape.melist.domain.usecase.GetProductDetailsUseCase
import com.svape.melist.domain.usecase.GetRecentSearchHistoryUseCase
import com.svape.melist.domain.usecase.SaveSearchHistoryUseCase
import com.svape.melist.domain.usecase.SearchProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideProductRepository(
        remoteDataSource: RemoteDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(remoteDataSource)
    }


    @Provides
    fun provideSearchProductsUseCase(
        productRepository: ProductRepository
    ): SearchProductsUseCase {
        return SearchProductsUseCase(productRepository)
    }

    @Provides
    fun provideGetProductDetailsUseCase(
        productRepository: ProductRepository
    ): GetProductDetailsUseCase {
        return GetProductDetailsUseCase(productRepository)
    }

    @Provides
    fun provideGetProductDescriptionUseCase(
        productRepository: ProductRepository
    ): GetProductDescriptionUseCase {
        return GetProductDescriptionUseCase(productRepository)
    }

    @Provides
    fun provideGetProductCategoryUseCase(
        productRepository: ProductRepository
    ): GetProductCategoryUseCase {
        return GetProductCategoryUseCase(productRepository)
    }

    @Provides
    fun provideSaveSearchHistoryUseCase(
        searchHistoryRepository: SearchHistoryRepository
    ): SaveSearchHistoryUseCase {
        return SaveSearchHistoryUseCase(searchHistoryRepository)
    }

    @Provides
    fun provideSearchHistoryUseCase(
        searchHistoryRepository: SearchHistoryRepository
    ): GetRecentSearchHistoryUseCase {
        return GetRecentSearchHistoryUseCase(searchHistoryRepository)
    }
}