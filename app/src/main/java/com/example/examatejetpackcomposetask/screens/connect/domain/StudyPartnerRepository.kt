package com.example.examatejetpackcomposetask.screens.connect.domain

interface StudyPartnerRepository {
   suspend fun getStudyPartners(): List<StudyPartner>
}
