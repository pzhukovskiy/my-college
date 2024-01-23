package com.example.project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project.data.database.dao.GroupDAO
import com.example.project.data.database.data.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class GroupDatabase: RoomDatabase() {
    abstract val dao: GroupDAO
}