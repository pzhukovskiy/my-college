package com.example.project.repository

import com.example.project.data.group.Group
import kotlinx.coroutines.flow.Flow

interface GroupsRepository {
    suspend fun fetchGroups(): Flow<List<Group>>
}