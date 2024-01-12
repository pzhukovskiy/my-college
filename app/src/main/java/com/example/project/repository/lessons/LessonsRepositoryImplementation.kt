package com.example.project.repository.lessons

import com.example.project.api.ApiService
import com.example.project.data.lessons.Lessons
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LessonsRepositoryImplementation : LessonsRepository {
    override suspend fun fetchLesson(): Flow<Lessons> {
        return flow {
            val lesson = ApiService.create().getLesson()
            emit(lesson)
        }
    }
}