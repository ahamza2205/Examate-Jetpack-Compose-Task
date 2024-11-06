package com.example.examatejetpackcomposetask.screens.questions.domain

interface QuestionRepository {
    suspend fun getOralQuestions(): List<Question>
    suspend fun getWritingQuestions(): List<Question>
}
