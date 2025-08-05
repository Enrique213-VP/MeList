package com.svape.melist.presentation.ui.state

import com.svape.melist.domain.model.Product

data class SearchResultsUiData(
    val query: String = "",
    val products: List<Product> = emptyList(),
    val hasSearched: Boolean = false
)