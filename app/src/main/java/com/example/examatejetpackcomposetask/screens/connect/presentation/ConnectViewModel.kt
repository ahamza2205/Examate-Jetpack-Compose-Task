package com.example.examatejetpackcomposetask.screens.connect.presentation

import androidx.lifecycle.ViewModel
import com.example.examatejetpackcomposetask.screens.connect.domain.GetStudyPartnersUseCase
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartner
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConnectViewModel @Inject constructor(
    private val getStudyPartnersUseCase: GetStudyPartnersUseCase
) : ViewModel() {
    val studyPartners: List<StudyPartner> = getStudyPartnersUseCase()
}
