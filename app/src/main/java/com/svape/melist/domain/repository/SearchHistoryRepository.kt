package com.svape.melist.domain.repository

import com.svape.melist.domain.model.SearchHistory
import kotlinx.coroutines.flow.Flow

interface SearchHistoryRepository {
    suspend fun saveSearchHistory(query: String)
    fun getRecentSearchHistory(): Flow<List<SearchHistory>>
}
