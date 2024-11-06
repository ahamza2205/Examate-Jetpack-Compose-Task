package com.example.examatejetpackcomposetask.screens.home.domain

interface StudyUnitRepository {
   suspend fun  getStudyUnits(): List<StudyUnit>
}
