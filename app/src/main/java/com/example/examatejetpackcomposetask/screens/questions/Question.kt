package com.example.examatejetpackcomposetask.screens.questions

data class Question(
    val category: String,
    val task: String,
    val description: String,
    val date: String,
    val answers: Int
)

val oralQuestions = listOf(
    Question("Events", "Task 2", "Je suis votre collègue, je participe chaque année...", "13 May 2023", 11),
    Question("Technology", "Task 3", "Quand quelqu'un quitte son pays...", "13 May 2023", 12)
)

val writingQuestions = listOf(
    Question("Voyage", "10 sur 10 Questions", "Progress 100%", "13 May 2023", 5),
    Question("Art et Culture", "5 sur 10 Questions", "Progress 50%", "13 May 2023", 7)
)
