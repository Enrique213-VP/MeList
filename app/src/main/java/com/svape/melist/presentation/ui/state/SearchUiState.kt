package com.svape.melist.presentation.ui.state


data class SearchUiData(
    val searchQuery: String = "",
    val recentSearches: List<String> = emptyList()
)