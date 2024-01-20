package com.example.project.repository.employee

import com.example.project.api.ApiService
import com.example.project.data.employees.Employee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmployeeRepositoryImplementation: EmployeeRepository {
    override suspend fun fetchEmployees(): Flow<List<Employee>> {
        return flow {
            val employees = ApiService.create().getEmployees()
            emit(employees)
        }
    }
}