package com.example.project.data.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item (
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val Name: String,
    val Group: Int
)