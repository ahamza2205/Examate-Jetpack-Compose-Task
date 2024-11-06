package com.example.examatejetpackcomposetask.screens.questions.domain

import javax.inject.Inject

class GetWritingQuestionsUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(): List<Question> = repository.getWritingQuestions()
}