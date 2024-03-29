package com.example.project.repository.news

import com.example.project.data.news.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun fetchNews(): Flow<List<News>>
}