package com.example.project.repository.employeeAHCH

import com.example.project.api.ApiService
import com.example.project.data.employeesahch.EmployeeAHCH
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmployeeRepositoryImplementationAHCH: EmployeeRepositoryAHCH {
    override suspend fun fetchEmployeesAHCH(): Flow<List<EmployeeAHCH>> {
        return flow {
            val employeesAHCH = ApiService.create().getEmployeesAHCH()
            emit(employeesAHCH)
        }
    }
}