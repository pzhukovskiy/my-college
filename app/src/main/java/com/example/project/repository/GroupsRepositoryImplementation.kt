package com.example.project.repository

import com.example.project.api.ApiService
import com.example.project.data.group.Group
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GroupsRepositoryImplementation: GroupsRepository {
    override suspend fun fetchGroups(): Flow<List<Group>> {
        return flow {
            val groups = ApiService.create().getGroups()
            emit(groups)
        }
    }
}