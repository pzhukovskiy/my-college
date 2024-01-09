package com.example.project.data.teachers


data class Teacher(
    val id: Int,
    val room: Room,
    val group: Int?,
    val date_create: String,
    val middle_name: String,
    val first_name: String,
    val last_name: String,
    val image: String,
    val description: String,
    val date_edit: String,
    val kurator: Boolean
)