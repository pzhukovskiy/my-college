package com.example.project.repository.news

import com.example.project.api.ApiService
import com.example.project.data.news.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImplementation: NewsRepository {
    override suspend fun fetchNews(): Flow<List<News>> {
        return flow {
            val news = ApiService.create().getNews()
            emit(news)
        }
    }
}