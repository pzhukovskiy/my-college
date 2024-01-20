package com.example.project.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.employees.Employee
import com.example.project.repository.employee.EmployeeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EmployeesViewModel(
    private val employeeRepository: EmployeeRepository,
    private val context: Context
) : ViewModel() {

    private val _employess = mutableStateListOf<Employee>()
    private var _filteredEmployeesList: List<Employee> by mutableStateOf(_employess)
    var errorMessage: String by mutableStateOf("")
    val employeeList: List<Employee>
        get() = _employess

    val filteredEmployeesList: List<Employee>
        get() = _filteredEmployeesList

    private var job: Job? = null

    init {
        if (isConnected()) {
            fetchData()
        } else {
            errorMessage = "No internet connection"
        }
    }

    fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

    fun fetchData() {
        job = viewModelScope.launch {
            try {
                employeeRepository.fetchEmployees().collect { employee ->
                    _employess.clear()
                    _employess.addAll(employee)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun filterEmployeeByFIO(query: String) {
        _filteredEmployeesList = if (query.isNotBlank()) {
            employeeList.filter { (it.first_name.contains(query, ignoreCase = true) || it.middle_name.contains(query, ignoreCase = true) || it.last_name.contains(query, ignoreCase = true)) }
        }
        else {
            employeeList
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getEmployee(): List<Employee> {
        return employeeList
    }
}