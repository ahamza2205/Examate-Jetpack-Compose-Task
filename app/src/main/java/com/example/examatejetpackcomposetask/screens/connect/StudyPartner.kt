package com.example.examatejetpackcomposetask.screens.connect

data class StudyPartner(
    val name: String,
    val targetLevel: String,
    val languages: List<String>,
    val location: String,
    val gender: String,
    val age: Int,
    val lastSeen: String,
    val joinDate: String
)

val studyPartners = listOf(
    StudyPartner(
        name = "Abdul-Rahman Hamza",
        targetLevel = "B1",
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = "Male",
        age = 26,
        lastSeen = "Yesterday",
        joinDate = "22 May 2023"
    ),
    StudyPartner(
        name = "Amira Mohamed",
        targetLevel = "B2",
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = "Female",
        age = 25,
        lastSeen = "Yesterday",
        joinDate = "23 March 2023"
    ),
    StudyPartner(
        name = "Mohamed Hassan",
        targetLevel = "B2",
        languages = listOf("English", "Arabic", "French"),
        location = "Egypt",
        gender = "Male",
        age = 27,
        lastSeen = "Yesterday",
        joinDate = "21 June 2024"
    )
)
