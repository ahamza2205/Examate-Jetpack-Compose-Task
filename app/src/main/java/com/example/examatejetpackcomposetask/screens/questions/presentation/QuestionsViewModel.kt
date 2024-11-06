package com.example.examatejetpackcomposetask.screens.questions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examatejetpackcomposetask.screens.questions.domain.GetOralQuestionsUseCase
import com.example.examatejetpackcomposetask.screens.questions.domain.GetWritingQuestionsUseCase
import com.example.examatejetpackcomposetask.screens.questions.domain.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val getOralQuestionsUseCase: GetOralQuestionsUseCase,
    private val getWritingQuestionsUseCase: GetWritingQuestionsUseCase
) : ViewModel() {

    private val _oralQuestions = MutableStateFlow<List<Question>>(emptyList())
    val oralQuestions: StateFlow<List<Question>> = _oralQuestions

    private val _writingQuestions = MutableStateFlow<List<Question>>(emptyList())
    val writingQuestions: StateFlow<List<Question>> = _writingQuestions

    init {
        loadOralQuestions()
        loadWritingQuestions()
    }

    private fun loadOralQuestions() {
        viewModelScope.launch {
            _oralQuestions.value = getOralQuestionsUseCase()
        }
    }

    private fun loadWritingQuestions() {
        viewModelScope.launch {
            _writingQuestions.value = getWritingQuestionsUseCase()
        }
    }
}
