package com.example.project.api

import com.example.project.data.photo.Curated
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    @Headers("Authorization: J3SMkLIvLBvYokLYMwwVRgSyAAcPVdhhfUxJO0b3plVSe5ybufszYk7B")
    @GET("curated")
    suspend fun getPhotos(): Curated

    companion object {
        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://api.pexels.com/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}