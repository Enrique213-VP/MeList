package com.svape.melist.data.remote.datasource

import com.svape.melist.data.remote.response.CategoryResponse
import com.svape.melist.data.remote.response.ProductDescriptionResponse
import com.svape.melist.data.remote.response.ProductDetailResponse
import com.svape.melist.data.remote.response.SearchResponse
import com.svape.melist.data.remote.service.ApiService
import com.svape.melist.domain.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val apiService: ApiService
) : RemoteDataSource {

    override fun searchProducts(query: String, offset: Int, limit: Int): Flow<SearchResponse> {
        return apiService.searchProducts(query, offset, limit)
    }

    override fun getProductDetails(productId: String): Flow<ProductDetailResponse> {
        return apiService.getProductDetails(productId)
    }

    override fun getProductDescription(productId: String): Flow<ProductDescriptionResponse> {
        return apiService.getProductDescription(productId)
    }

    override fun getProductCategory(categoryId: String): Flow<CategoryResponse> {
        return apiService.getProductCategory(categoryId)
    }
}
