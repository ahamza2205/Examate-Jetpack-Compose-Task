package com.example.examatejetpackcomposetask.screens.connect.data

import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartner
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartnerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudyPartnerRepositoryImpl @Inject constructor() : StudyPartnerRepository {
    override fun getStudyPartners(): List<StudyPartner> {
        return listOf(
            StudyPartner("Abdul-Rahman Hamza", "B1", listOf("English", "Arabic", "French"), "Egypt", "Male", 26, "Yesterday", "22 May 2023"),
            StudyPartner("Amira Mohamed", "B2", listOf("English", "Arabic", "French"), "Egypt", "Female", 25, "Yesterday", "23 March 2023"),
            StudyPartner("Mohamed Hassan", "B2", listOf("English", "Arabic", "French"), "Egypt", "Male", 27, "Yesterday", "21 June 2024")
        )
    }
}
