package com.svape.melist.data.remote

import android.content.Context
import android.util.Log
import com.svape.melist.data.remote.response.CategoryResponse
import com.svape.melist.data.remote.response.ProductDescriptionResponse
import com.svape.melist.data.remote.response.ProductDetailResponse
import com.svape.melist.data.remote.response.SearchResponse
import com.svape.melist.data.remote.service.ApiService
import com.svape.melist.data.remote.utils.ApiExceptionMapper
import com.svape.melist.data.remote.utils.AssetFileReader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class ApiServiceImp(
    context: Context
) : ApiService {

    companion object {
        private const val TAG = "ApiServiceImp"
    }

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        encodeDefaults = true
    }

    private val fileReader = AssetFileReader(context)

    override fun searchProducts(query: String, offset: Int, limit: Int): Flow<SearchResponse> =
        flow {
            try {
                Log.d(TAG, "Query: '$query'")
                val fileName = fileReader.buildSearchFileName(query)
                val jsonString = fileReader.readFile(fileName)
                val response = json.decodeFromString<SearchResponse>(jsonString)

                emit(response)

            } catch (e: Exception) {
                throw ApiExceptionMapper.mapToApiException(e, "Failed to search products")
            }
        }

    override fun getProductDetails(productId: String): Flow<ProductDetailResponse> =
        flow {
            try {
                val fileName = "items/item-$productId.json"
                val jsonString = fileReader.readFile(fileName)
                val response = json.decodeFromString<ProductDetailResponse>(jsonString)

                emit(response)

            } catch (e: Exception) {
                throw ApiExceptionMapper.mapToApiException(e, "Failed to get product details")
            }
        }

    override fun getProductDescription(productId: String): Flow<ProductDescriptionResponse> =
        flow {
            try {
                val fileName = "descriptions/item-$productId-description.json"
                val jsonString = fileReader.readFile(fileName)
                val response = json.decodeFromString<ProductDescriptionResponse>(jsonString)

                emit(response)

            } catch (e: Exception) {
                throw ApiExceptionMapper.mapToApiException(e, "Failed to get product description")
            }
        }

    override fun getProductCategory(categoryId: String): Flow<CategoryResponse> =
        flow {
            try {
                val fileName = "categories/item-$categoryId-category.json"
                val jsonString = fileReader.readFile(fileName)
                val response = json.decodeFromString<CategoryResponse>(jsonString)

                emit(response)

            } catch (e: Exception) {
                throw ApiExceptionMapper.mapToApiException(e, "Failed to get category")
            }
        }
}