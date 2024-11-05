package com.example.examatejetpackcomposetask.screens.questions

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import oralQuestions
import writingQuestions

@Composable
fun QuestionsScreen() {
    var selectedTab by remember { mutableStateOf("Oral") }

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Header()
            TabRow(selectedTab) { selectedTab = it }
            FilterRow()
            if (selectedTab == "Oral") {
                OralQuestionsList()
            } else {
                WritingQuestionsList()
            }
        }
    }
}

@Composable
fun Header() {
    Text(
        text = "Questions",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = PrimaryColor
    )
}

@Composable
fun TabRow(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row {
        TabButton("Writing", selectedTab) { onTabSelected("Writing") }
        Spacer(modifier = Modifier.width(16.dp))
        TabButton("Oral", selectedTab) { onTabSelected("Oral") }
    }
}

@Composable
fun FilterRow() {
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
        // Assuming you have a filter icon in your drawable resources
        Icon(
            painter = painterResource(id = R.drawable.filter),
            contentDescription = "Filter Icon",
            tint = PrimaryColor
        )
    }
}
@Composable
fun OralQuestionsList() {
    LazyColumn {
        items(oralQuestions.size) { index ->
            OralQuestionCard(oralQuestions[index])
        }
    }
}

@Composable
fun WritingQuestionsList() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(writingQuestions.size) { index ->
            WritingQuestionCard(writingQuestions[index])
        }
    }
}
