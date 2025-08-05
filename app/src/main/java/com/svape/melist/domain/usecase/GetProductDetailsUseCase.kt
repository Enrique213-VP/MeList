package com.svape.melist.domain.usecase

import android.util.Log
import com.svape.melist.domain.model.ProductDetail
import com.svape.melist.domain.repository.ProductRepository
import com.svape.melist.domain.util.DomainValidator
import com.svape.melist.domain.util.ResultUseCase
import com.svape.melist.domain.util.safeExecute
import kotlinx.coroutines.flow.Flow

class GetProductDetailsUseCase(
    private val productRepository: ProductRepository
) {
    companion object {
        private const val TAG = "GetProductDetailsUseCase"
    }

    operator fun invoke(productId: String): Flow<ResultUseCase<ProductDetail>> {
        Log.d(TAG, "invoke: Getting product details for productId='$productId'")

        return safeExecute(
            tag = TAG,
            validation = {
                DomainValidator.validateProductId(productId)
            },
            execution = {
                productRepository.getProductDetails(productId)
            },
            errorMessage = "Failed to get product details"
        )
    }
}
