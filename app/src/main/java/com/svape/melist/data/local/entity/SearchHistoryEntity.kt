package com.svape.melist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.svape.melist.domain.model.SearchHistory

@Entity(tableName = "search_history")
data class SearchHistoryEntity(
    @PrimaryKey
    val query: String,
    val timestamp: Long = System.currentTimeMillis()
) {

    fun toSearchHistory() = SearchHistory(query, timestamp)

}
