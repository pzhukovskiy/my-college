package com.example.project.repository.lessons

import com.example.project.data.lessons.Lessons
import kotlinx.coroutines.flow.Flow

interface LessonsRepository {
    suspend fun fetchLesson(): Flow<Lessons>
}
