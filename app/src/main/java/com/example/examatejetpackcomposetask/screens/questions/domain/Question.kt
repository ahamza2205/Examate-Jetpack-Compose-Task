package com.example.examatejetpackcomposetask.screens.questions.domain

data class Question(
    val category: String,
    val task: String,
    val description: String,
    val date: String,
    val answers: Int,
    val progress: Int
)
