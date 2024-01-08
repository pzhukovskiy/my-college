package com.example.project.repository

import com.example.project.data.photo.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun fetchPhotos(): Flow<List<Photo>>
}