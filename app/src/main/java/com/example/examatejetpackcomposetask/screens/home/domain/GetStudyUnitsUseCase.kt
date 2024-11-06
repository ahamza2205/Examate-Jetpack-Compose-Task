package com.example.examatejetpackcomposetask.screens.home.domain

import javax.inject.Inject

class GetStudyUnitsUseCase @Inject constructor(
    private val repository: StudyUnitRepository
) {
    suspend operator fun invoke(): List<StudyUnit> {
        return repository.getStudyUnits()
    }
}

