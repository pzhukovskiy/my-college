package com.example.project.data.news

data class News(
    val id: Int,
    val date_create: String,
    val title: String,
    val image: String,
    val description: String,
    val main_text: String,
    val date_edit: String
)