package com.example.project.repository.administration

import com.example.project.data.administrators.Administrator
import kotlinx.coroutines.flow.Flow

interface AdministratorRepository {
    suspend fun fetchAdministrators(): Flow<List<Administrator>>
}