package com.example.examatejetpackcomposetask.screens.connect.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examatejetpackcomposetask.screens.connect.domain.GetStudyPartnersUseCase
import com.example.examatejetpackcomposetask.screens.connect.domain.StudyPartner
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConnectViewModel @Inject constructor(
    private val getStudyPartnersUseCase: GetStudyPartnersUseCase
) : ViewModel() {

    private val _studyPartners = MutableStateFlow<List<StudyPartner>>(emptyList())
    val studyPartners: StateFlow<List<StudyPartner>> = _studyPartners

    init {
        loadStudyPartners()
    }
    private fun loadStudyPartners() {
        viewModelScope.launch {
            _studyPartners.value = getStudyPartnersUseCase()
        }
    }

}
