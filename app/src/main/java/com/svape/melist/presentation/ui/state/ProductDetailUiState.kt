package com.svape.melist.presentation.ui.state

import com.svape.melist.domain.model.Category
import com.svape.melist.domain.model.Product
import com.svape.melist.domain.model.ProductDetail


data class ProductDetailUiData(
    val baseProduct: Product? = null,
    val productDetail: ProductDetail? = null,
    val description: String? = null,
    val category: Category? = null,
    val query: String = ""
)