package com.example.examatejetpackcomposetask.screens.connect.domain

import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import javax.inject.Inject

class GetStudyPartnersUseCase @Inject constructor(
    private val repository: StudyPartnerRepository
) {
    suspend operator fun invoke(): List<StudyPartner> {
        return repository.getStudyPartners()
    }
}
