package com.example.project.data.database

import com.example.project.data.database.data.Item

sealed interface GroupEvent {
    object SaveGroup: GroupEvent
    data class SetGroupName(val Name: String): GroupEvent
    data class SetGroupId(val Group: Int): GroupEvent
    data class DeleteItem(val group: Item): GroupEvent
    data class SortGroups(val sortType: SortType): GroupEvent
}