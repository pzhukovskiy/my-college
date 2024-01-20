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
import com.example.project.data.employeesahch.EmployeeAHCH
import com.example.project.repository.employeeAHCH.EmployeeRepositoryAHCH
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EmployeesAhchViewModel(
    private val employeeAhchRepository: EmployeeRepositoryAHCH,
    private val context: Context
) : ViewModel() {

    private val _employessAhch = mutableStateListOf<EmployeeAHCH>()
    private var _filteredEmployeesAhchList: List<EmployeeAHCH> by mutableStateOf(_employessAhch)
    var errorMessage: String by mutableStateOf("")
    val employeeAhchList: List<EmployeeAHCH>
        get() = _employessAhch

    val filteredEmployeesAhchList: List<EmployeeAHCH>
        get() = _filteredEmployeesAhchList

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
                employeeAhchRepository.fetchEmployeesAHCH().collect { employeeAhch ->
                    _employessAhch.clear()
                    _employessAhch.addAll(employeeAhch)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun filterEmployeeAhchByFIO(query: String) {
        _filteredEmployeesAhchList = if (query.isNotBlank()) {
            employeeAhchList.filter { (it.first_name.contains(query, ignoreCase = true) || it.middle_name.contains(query, ignoreCase = true) || it.last_name.contains(query, ignoreCase = true)) }
        }
        else {
            employeeAhchList
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getEmployeeAhch(): List<EmployeeAHCH> {
        return employeeAhchList
    }
}