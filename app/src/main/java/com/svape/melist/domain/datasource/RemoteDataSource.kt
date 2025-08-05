package com.svape.melist.domain.datasource

import com.svape.melist.data.remote.response.CategoryResponse
import com.svape.melist.data.remote.response.ProductDescriptionResponse
import com.svape.melist.data.remote.response.ProductDetailResponse
import com.svape.melist.data.remote.response.SearchResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun searchProducts(
        query: String,
        offset: Int = 0,
        limit: Int = 50
    ): Flow<SearchResponse>

    fun getProductDetails(
        productId: String
    ): Flow<ProductDetailResponse>

    fun getProductDescription(
        productId: String
    ): Flow<ProductDescriptionResponse>

    fun getProductCategory(
        categoryId: String
    ): Flow<CategoryResponse>
}