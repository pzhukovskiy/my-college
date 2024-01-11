package com.example.project.data.lessons

import com.example.project.data.corpus.Corpus
import com.example.project.data.group.Group
import com.example.project.data.subject.Subject
import com.example.project.data.teachers.Room
import com.example.project.data.teachers.Teacher

data class Lessons(
    val id: Int,
    val room: Room,
    val teacher: Teacher,
    val subject: Subject,
    val group: Group,
    val corpus: Corpus,
    val subgroup: Int,
    val lesson_type: String,
    val lesson_number: Int,
    val date: String
)