package com.example.project.repository.lessons

import com.example.project.data.lessons.Lessons
import kotlinx.coroutines.flow.Flow

interface LessonsRepository {
    suspend fun fetchLessonsGroup(id: Int): Flow<List<Lessons>>
    suspend fun fetchLessonsTeacher(id: Int): Flow<List<Lessons>>
    suspend fun fetchLessonsForWeekGroup(): Flow<List<Lessons>>
    suspend fun fetchLessonsForWeekTeacher(): Flow<List<Lessons>>
}
