package com.example.project.repository.teachers

import com.example.project.api.ApiService
import com.example.project.data.teachers.Teacher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TeacherRepositoryImplementation: TeacherRepository {
    override suspend fun fetchTeachers(): Flow<List<Teacher>> {
        return flow {
            val teachers = ApiService.create().getTeachers()
            emit(teachers)
        }
    }
}