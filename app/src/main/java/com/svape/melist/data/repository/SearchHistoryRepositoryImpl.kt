package com.svape.melist.data.repository

import com.svape.melist.data.local.dao.SearchHistoryDao
import com.svape.melist.data.local.entity.SearchHistoryEntity
import com.svape.melist.domain.model.SearchHistory
import com.svape.melist.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map

class SearchHistoryRepositoryImpl(
    private val searchHistoryDao: SearchHistoryDao
) : SearchHistoryRepository {

    override suspend fun saveSearchHistory(query: String) {
        searchHistoryDao.insertSearchHistory(SearchHistoryEntity(query = query))
    }

    override fun getRecentSearchHistory(): Flow<List<SearchHistory>> {
        return searchHistoryDao.getRecentSearchHistory()
            .map { entities -> entities.map { it.toSearchHistory() } }
    }

}
