package com.example.project.data.database

import com.example.project.data.database.data.Item

data class GroupState(
    val groups: List<Item> = emptyList(),
    val Name: String = "",
    val Group: Int = 0,
    val sortType: SortType = SortType.GROUP,
    val isAddingGroup: Boolean = false,
)