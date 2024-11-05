package com.example.examatejetpackcomposetask.screens.questions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor

@Composable
fun QuestionsScreen() {
    var selectedTab by remember { mutableStateOf("Oral") }

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header and Tabs
            Text(
                text = "Questions",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = PrimaryColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                TabButton("Writing", selectedTab) { selectedTab = "Writing" }
                Spacer(modifier = Modifier.width(16.dp))
                TabButton("Oral", selectedTab) { selectedTab = "Oral" }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show the question cards based on selected tab
            if (selectedTab == "Oral") {
                OralQuestionsList()
            } else {
                WritingQuestionsList()
            }
        }
    }
}

@Composable
fun TabButton(title: String, selectedTab: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (title == selectedTab) PrimaryColor else Color.Transparent
        )
    ) {
        Text(
            text = title,
            color = if (title == selectedTab) Color.White else PrimaryColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun OralQuestionsList() {
    Column {
        oralQuestions.forEach { question ->
            OralQuestionCard(question)
        }
    }
}

@Composable
fun WritingQuestionsList() {
    Column {
        writingQuestions.forEach { question ->
            WritingQuestionCard(question)
        }
    }
}


