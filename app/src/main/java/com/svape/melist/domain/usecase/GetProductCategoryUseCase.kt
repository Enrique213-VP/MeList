package com.svape.melist.domain.usecase

import android.util.Log
import com.svape.melist.domain.model.Category
import com.svape.melist.domain.repository.ProductRepository
import com.svape.melist.domain.util.DomainValidator
import com.svape.melist.domain.util.ResultUseCase
import com.svape.melist.domain.util.safeExecute
import kotlinx.coroutines.flow.Flow

class GetProductCategoryUseCase(
    private val productRepository: ProductRepository
) {
    companion object {
        private const val TAG = "GetProductCategoryUseCase"
    }

    operator fun invoke(categoryId: String): Flow<ResultUseCase<Category>> {
        Log.d(TAG, "invoke: Starting to get category for categoryId='$categoryId'")

        return safeExecute(
            tag = TAG,
            validation = {
                DomainValidator.validateCategoryId(categoryId)
            },
            execution = {
                productRepository.getProductCategory(categoryId)
            },
            errorMessage = "Failed to get category"
        )
    }
}
