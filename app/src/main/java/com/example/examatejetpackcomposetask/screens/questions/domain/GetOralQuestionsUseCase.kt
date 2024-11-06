package com.example.examatejetpackcomposetask.screens.questions.domain

import javax.inject.Inject

class GetOralQuestionsUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    suspend operator fun invoke(): List<Question> = repository.getOralQuestions()
}
