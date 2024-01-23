package com.example.project.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.project.data.database.data.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDAO {

    @Upsert
    suspend fun upsertGroup(group: Item)

    @Delete
    suspend fun deleteGroup(group: Item)

    @Query("SELECT * FROM item ORDER BY Name ASC")
    fun getGroupsOrderedByName(): Flow<List<Item>>
}