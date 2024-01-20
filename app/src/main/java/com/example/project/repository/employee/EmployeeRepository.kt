package com.example.project.repository.employee

import com.example.project.data.employees.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun fetchEmployees(): Flow<List<Employee>>
}