package com.example.project.repository.teachers

import com.example.project.data.teachers.Teacher
import kotlinx.coroutines.flow.Flow

interface TeacherRepository {
    suspend fun fetchTeachers(): Flow<List<Teacher>>
}