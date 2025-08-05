package com.svape.melist.domain.repository

import com.svape.melist.domain.model.Category
import com.svape.melist.domain.model.Product
import com.svape.melist.domain.model.ProductDetail
import com.svape.melist.domain.model.ProductDescription
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun searchProducts(
        query: String,
        offset: Int = 0,
        limit: Int = 50
    ): Flow<List<Product>>

    fun getProductDetails(
        productId: String
    ): Flow<ProductDetail>

    fun getProductDescription(
        productId: String
    ): Flow<ProductDescription>

    fun getProductCategory(
        categoryId: String
    ): Flow<Category>
}
