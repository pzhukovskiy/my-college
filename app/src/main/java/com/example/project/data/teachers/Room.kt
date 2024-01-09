package com.example.project.data.teachers

import com.example.project.data.corpus.Corpus

data class Room(
    val id: Int,
    val corpus: Corpus,
    val room: String
)