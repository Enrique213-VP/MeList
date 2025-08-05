package com.svape.melist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.svape.melist.data.local.dao.SearchHistoryDao
import com.svape.melist.data.local.entity.SearchHistoryEntity

@Database(
    entities = [SearchHistoryEntity::class],
    version = 1
)
abstract class MercadoLibreDatabase : RoomDatabase() {
    abstract val searchHistoryDao: SearchHistoryDao
}
