package com.example.project.repository.lessons

import com.example.project.api.ApiService
import com.example.project.data.lessons.Lessons
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LessonsRepositoryImplementation : LessonsRepository {

    override suspend fun fetchLessonsGroup(id: Int): Flow<List<Lessons>> {
        return flow {
            val lesson = ApiService.create().getLessonsGroup(id)
            emit(lesson)
        }
    }

    override suspend fun fetchLessonsTeacher(id: Int): Flow<List<Lessons>> {
        return flow {
            val lesson = ApiService.create().getLessonsTeacher(id)
            emit(lesson)
        }
    }

    override suspend fun fetchLessonsForWeekGroup(): Flow<List<Lessons>> {
        return flow {
            val lessons = ApiService.create().getLessonsForWeekGroup()
            emit(lessons)
        }
    }

    override suspend fun fetchLessonsForWeekTeacher(): Flow<List<Lessons>> {
        return flow {
            val lessons = ApiService.create().getLessonsForWeekTeacher()
            emit(lessons)
        }
    }
}