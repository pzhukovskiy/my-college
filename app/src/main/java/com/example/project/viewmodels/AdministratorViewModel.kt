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
import com.example.project.data.administrators.Administrator
import com.example.project.repository.AdministratorRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AdministratorViewModel(
    private val administratorRepository: AdministratorRepository,
    private val context: Context
) : ViewModel() {

    private val _administrators = mutableStateListOf<Administrator>()
    private var _filteredAdministratorList: List<Administrator> by mutableStateOf(_administrators)
    var errorMessage: String by mutableStateOf("")
    val administratorList: List<Administrator>
        get() = _administrators

    val filteredAdministratorList: List<Administrator>
        get() = _filteredAdministratorList

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
                administratorRepository.fetchAdministrators().collect { administrator ->
                    _administrators.clear()
                    _administrators.addAll(administrator)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun filterAdministratorByFIO(query: String) {
        _filteredAdministratorList = if (query.isNotBlank()) {
            administratorList.filter { (it.first_name.contains(query, ignoreCase = true) || it.middle_name.contains(query, ignoreCase = true) || it.last_name.contains(query, ignoreCase = true)) }
        }
        else {
            administratorList
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getAdministrator(): List<Administrator> {
        return administratorList
    }
}