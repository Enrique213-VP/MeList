package com.svape.melist.domain.usecase

import android.util.Log
import com.svape.melist.domain.model.ProductDescription
import com.svape.melist.domain.repository.ProductRepository
import com.svape.melist.domain.util.DomainValidator
import com.svape.melist.domain.util.ResultUseCase
import com.svape.melist.domain.util.safeExecute
import kotlinx.coroutines.flow.Flow

class GetProductDescriptionUseCase(
    private val productRepository: ProductRepository
) {
    companion object {
        private const val TAG = "GetProductDescriptionUseCase"
    }

    operator fun invoke(productId: String): Flow<ResultUseCase<ProductDescription>> {
        Log.d(TAG, "invoke: Getting product description for productId='$productId'")

        return safeExecute(
            tag = TAG,
            validation = {
                DomainValidator.validateProductId(productId)
            },
            execution = {
                productRepository.getProductDescription(productId)
            },
            errorMessage = "Failed to get product description"
        )
    }
}
