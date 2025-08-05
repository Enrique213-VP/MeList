package com.svape.melist.data.repository

import com.svape.melist.data.mapper.toDomain
import com.svape.melist.domain.datasource.RemoteDataSource
import com.svape.melist.data.remote.response.CategoryResponse
import com.svape.melist.data.remote.response.ProductDescriptionResponse
import com.svape.melist.data.remote.response.ProductDetailResponse
import com.svape.melist.data.remote.response.SearchResponse
import com.svape.melist.domain.model.Category
import com.svape.melist.domain.model.Product
import com.svape.melist.domain.model.ProductDescription
import com.svape.melist.domain.model.ProductDetail
import com.svape.melist.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepositoryImpl (
    private val remoteDataSource: RemoteDataSource
) : ProductRepository {

    override fun searchProducts(query: String, offset: Int, limit: Int): Flow<List<Product>> {
        return remoteDataSource.searchProducts(query, offset, limit)
            .map { response: SearchResponse -> response.toDomain() }
    }

    override fun getProductDetails(productId: String): Flow<ProductDetail> {
        return remoteDataSource.getProductDetails(productId)
            .map { response: ProductDetailResponse -> response.toDomain() }
    }

    override fun getProductDescription(productId: String): Flow<ProductDescription> {
        return remoteDataSource.getProductDescription(productId)
            .map { response: ProductDescriptionResponse -> response.toDomain() }
    }

    override fun getProductCategory(categoryId: String): Flow<Category> {
        return remoteDataSource.getProductCategory(categoryId)
            .map { response: CategoryResponse -> response.toDomain() }
    }
}
