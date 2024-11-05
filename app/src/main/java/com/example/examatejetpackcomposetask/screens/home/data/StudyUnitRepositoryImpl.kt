package com.example.examatejetpackcomposetask.screens.home.data

import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnitRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudyUnitRepositoryImpl @Inject constructor() : StudyUnitRepository {
    override fun getStudyUnits(): List<StudyUnit> {
        return listOf(
            StudyUnit(1, "Unit 1:", "What is Examate?", false),
            StudyUnit(2, "Unit 2:", "What is TCF?", true),
            StudyUnit(3, "Writing Tasks", "", true),
            StudyUnit(4, "Oral Task", "", true)
        )
    }
}

