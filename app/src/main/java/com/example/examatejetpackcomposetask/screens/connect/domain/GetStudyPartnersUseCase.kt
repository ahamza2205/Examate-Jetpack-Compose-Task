package com.example.examatejetpackcomposetask.screens.connect.domain

import javax.inject.Inject

class GetStudyPartnersUseCase @Inject constructor(
    private val repository: StudyPartnerRepository
) {
    operator fun invoke(): List<StudyPartner> {
        return repository.getStudyPartners()
    }
}
