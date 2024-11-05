package com.example.examatejetpackcomposetask.screens.home.domain

import javax.inject.Inject

class GetStudyUnitsUseCase @Inject constructor(
    private val repository: StudyUnitRepository
) {
    operator fun invoke(): List<StudyUnit> {
        return repository.getStudyUnits()
    }
}

