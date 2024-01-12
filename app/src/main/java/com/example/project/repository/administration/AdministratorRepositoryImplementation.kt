package com.example.project.repository.administration

import com.example.project.api.ApiService
import com.example.project.data.administrators.Administrator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AdministratorRepositoryImplementation: AdministratorRepository {
    override suspend fun fetchAdministrators(): Flow<List<Administrator>> {
        return flow {
            val administrators = ApiService.create().getAdministrators()
            emit(administrators)
        }
    }
}