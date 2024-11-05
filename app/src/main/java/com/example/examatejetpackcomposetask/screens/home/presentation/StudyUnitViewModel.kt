package com.example.examatejetpackcomposetask.screens.home.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examatejetpackcomposetask.screens.home.domain.GetStudyUnitsUseCase
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudyUnitViewModel @Inject constructor(
    private val getStudyUnitsUseCase: GetStudyUnitsUseCase
) : ViewModel() {

    private val _studyUnits = MutableStateFlow<List<StudyUnit>>(emptyList())
    val studyUnits: StateFlow<List<StudyUnit>> = _studyUnits

    init {
        loadStudyUnits()
    }

    private fun loadStudyUnits() {
        viewModelScope.launch {
            _studyUnits.value = getStudyUnitsUseCase()
        }
    }
}
