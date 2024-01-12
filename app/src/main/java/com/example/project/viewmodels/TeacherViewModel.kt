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
import com.example.project.data.teachers.Teacher
import com.example.project.repository.teachers.TeacherRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TeacherViewModel(
    private val teacherRepository: TeacherRepository,
    private val context: Context
) : ViewModel() {

    private val _teachers = mutableStateListOf<Teacher>()
    private var _filteredTeacherList: List<Teacher> by mutableStateOf(_teachers)
    var errorMessage: String by mutableStateOf("")
    val teachersList: List<Teacher>
        get() = _teachers

    val filteredTeacherList: List<Teacher>
        get() = _filteredTeacherList

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
                teacherRepository.fetchTeachers().collect { teachers ->
                    _teachers.clear()
                    _teachers.addAll(teachers)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun filterTeacherByFIO(query: String) {
        _filteredTeacherList = if (query.isNotBlank()) {
            teachersList.filter { (it.first_name.contains(query, ignoreCase = true)) || (it.last_name.contains(query, ignoreCase = true) || it.middle_name.contains(query, ignoreCase = true)) }
        }
        else {
            teachersList
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getTeacher(): List<Teacher> {
        return teachersList
    }
}
