package com.example.project.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.api.ApiService
import com.example.project.data.lessons.Lessons
import com.example.project.repository.lessons.LessonsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LessonsViewModel(
    private val lessonsRepository: LessonsRepository,
    private val context: Context
) : ViewModel() {

    private val _lessons = mutableStateListOf<Lessons>()
    var errorMessage: String by mutableStateOf("")
    val lessonsList: List<Lessons>
        get() = _lessons

    private var job: Job? = null

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

    fun fetchLessonsGroup(id: Int) {
        job = viewModelScope.launch {
            try {
                lessonsRepository.fetchLessonsGroup(id).collect {
                    _lessons.clear()
                    _lessons.addAll(it)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun fetchLessonsTeacher(id: Int) {
        job = viewModelScope.launch {
            try {
                lessonsRepository.fetchLessonsTeacher(id).collect {
                    _lessons.clear()
                    _lessons.addAll(it)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun fetchLessonsForWeekGroup() {
        job = viewModelScope.launch {
            try {
                lessonsRepository.fetchLessonsForWeekGroup().collect {
                    _lessons.clear()
                    _lessons.addAll(it)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    fun fetchLessonsForWeekTeacher() {
        job = viewModelScope.launch {
            try {
                lessonsRepository.fetchLessonsForWeekTeacher().collect {
                    _lessons.clear()
                    _lessons.addAll(it)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }
}