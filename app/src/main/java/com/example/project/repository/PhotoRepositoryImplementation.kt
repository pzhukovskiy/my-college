package com.example.project.repository

import com.example.project.api.ApiService
import com.example.project.data.photo.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PhotoRepositoryImplementation: PhotoRepository {
    override suspend fun fetchPhotos(): Flow<List<Photo>> {
        return flow {
            val photos = ApiService.create().getPhotos().photos
            emit(photos)
        }
    }
}