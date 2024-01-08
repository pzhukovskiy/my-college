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
import com.example.project.data.photo.Photo
import com.example.project.repository.PhotoRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhotoViewModel(
    private val imageRepository: PhotoRepository,
    private val context: Context
) : ViewModel() {

    private val _photos = mutableStateListOf<Photo>()
    private var _filteredPhotoList: List<Photo> by mutableStateOf(_photos)
    var errorMessage: String by mutableStateOf("")
    val photoList: List<Photo>
        get() = _photos

    val filteredPhotoList: List<Photo>
        get() = _filteredPhotoList

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
                imageRepository.fetchPhotos().collect { photos ->
                    _photos.clear()
                    _photos.addAll(photos)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching photos: ${e.message}"
            }
        }
    }

    fun filterPhotosByPhotographer(query: String) {
        _filteredPhotoList = if (query.isNotBlank()) {
            photoList.filter { it.photographer.contains(query, ignoreCase = true) }
        } else {
            photoList
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getPhoto(): List<Photo> {
        return photoList
    }
}
