package com.example.examatejetpackcomposetask.screens.questions.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.questions.ui.OralQuestionCard
import com.example.examatejetpackcomposetask.screens.questions.ui.TabButton
import com.example.examatejetpackcomposetask.screens.questions.ui.WritingQuestionCard
import com.example.examatejetpackcomposetask.screens.questions.domain.Question
import com.example.examatejetpackcomposetask.tutorial.TutorialDialog
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    var selectedTab by remember { mutableStateOf("Oral") }
    val oralQuestions = viewModel.oralQuestions.collectAsState().value
    val writingQuestions = viewModel.writingQuestions.collectAsState().value

    // State to control tutorial steps
    var tutorialStep by remember { mutableStateOf(1) }

    // Handling the tutorial steps
    when (tutorialStep) {
        1 -> {
            QuestionsTutorialDialog(
                text = "Voici les questions avec\n des réponses modèles",
                alignment = Alignment.BottomStart,
                offsetX = 150.dp,
                offsetY = -75.dp,
                onDismiss = { tutorialStep = 0 },
                onNextStep = { tutorialStep = 2 }
            )
        }

        2 -> {
            QuestionsTutorialDialog(
                text = "Vous pouvez filtrer pour voir un type \n exact de questions",
                alignment = Alignment.TopStart,
                offsetX = 20.dp,
                offsetY = 110.dp,
                onDismiss = { tutorialStep = 0 },
                onNextStep = {
                    tutorialStep = 3
                    selectedTab = "Writing"
                }
            )
        }

        3 -> {
            QuestionsTutorialDialog(
                text = "Cliquez ici pour voir par catégories \n avec progression",
                alignment = Alignment.TopStart,
                offsetX = 50.dp,
                offsetY = 70.dp,
                onDismiss = { tutorialStep = 0 },
                onNextStep = { tutorialStep = 0 }
            )
        }
    }

    // Main layout with white background
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Header()
            TabRow(selectedTab) { selectedTab = it }
            FilterRow()
            // Display the list based on the selected tab
            if (selectedTab == "Oral") {
                OralQuestionsList(oralQuestions)
            } else {
                WritingQuestionsList(writingQuestions)
            }
        }
    }
}

@Composable
fun Header() {
    // Displays the title for the screen
    Text(
        text = "Questions",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = PrimaryColor
    )
}

@Composable
fun TabRow(selectedTab: String, onTabSelected: (String) -> Unit) {
    // Row of buttons to switch between Oral and Writing tabs
    Row {
        TabButton("Writing", selectedTab) { onTabSelected("Writing") }
        Spacer(modifier = Modifier.width(16.dp))
        TabButton("Oral", selectedTab) { onTabSelected("Oral") }
    }
}

@Composable
fun FilterRow() {
    // Row containing filter label and icon
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Filter",
            style = MaterialTheme.typography.titleLarge,
            color = PrimaryColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter Icon",
            tint = PrimaryColor
        )
    }
}

@Composable
fun OralQuestionsList(questions: List<Question>) {
    // Displaying a list of oral questions using LazyColumn
    LazyColumn {
        items(questions.size) { index ->
            OralQuestionCard(questions[index])
        }
    }
}

@Composable
fun WritingQuestionsList(questions: List<Question>) {
    // Displaying a grid of writing questions with two columns using LazyVerticalGrid
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(questions.size) { index ->
            WritingQuestionCard(questions[index])
        }
    }
}

@Composable
fun QuestionsTutorialDialog(
    text: String,
    alignment: Alignment,
    offsetX: Dp,
    offsetY: Dp,
    onDismiss: () -> Unit,
    onNextStep: () -> Unit
) {
    TutorialDialog(
        text = text,
        alignment = alignment,
        onDismiss = onDismiss,
        onNextStep = onNextStep,
        offsetX = offsetX,
        offsetY = offsetY
    )
}
