package com.example.project.api

import com.example.project.BuildConfig
import com.example.project.data.administrators.Administrator
import com.example.project.data.group.Group
import com.example.project.data.lessons.Lessons
import com.example.project.data.news.News
import com.example.project.data.teachers.Teacher
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers(BuildConfig.API_KEY)
    @GET("teachers")
    suspend fun getTeachers(): List<Teacher>

    @Headers(BuildConfig.API_KEY)
    @GET("administrators")
    suspend fun getAdministrators(): List<Administrator>

    @Headers(BuildConfig.API_KEY)
    @GET("news")
    suspend fun getNews(): List<News>

    @Headers(BuildConfig.API_KEY)
    @GET("groups")
    suspend fun getGroups(): List<Group>

    @Headers(BuildConfig.API_KEY)
    @GET("lessons")
    suspend fun getLessons(): List<Lessons>

    @Headers(BuildConfig.API_KEY)
    @GET("lessons/2")
    suspend fun getLesson(): Lessons


    companion object {
        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}