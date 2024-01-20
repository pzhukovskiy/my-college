package com.example.project.repository.employeeAHCH

import com.example.project.data.employeesahch.EmployeeAHCH
import kotlinx.coroutines.flow.Flow

interface EmployeeRepositoryAHCH {
    suspend fun fetchEmployeesAHCH(): Flow<List<EmployeeAHCH>>
}