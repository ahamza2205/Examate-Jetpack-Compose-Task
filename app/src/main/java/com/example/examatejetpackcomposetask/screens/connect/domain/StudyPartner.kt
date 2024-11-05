package com.example.examatejetpackcomposetask.screens.connect.domain

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

