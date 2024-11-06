package com.example.examatejetpackcomposetask.screens.questions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.questions.domain.Question
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SurfaceColor

@Composable
fun OralQuestionCard(question: Question) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            HeaderText(category = question.category, task = question.task)
            Spacer(modifier = Modifier.height(4.dp))
            DescriptionText(description = question.description)
            Spacer(modifier = Modifier.height(8.dp))
            FooterRow(answers = question.answers, date = question.date)
        }
    }
}

@Composable
fun HeaderText(category: String, task: String) {
    Text(
        text = "$category - $task",
        style = MaterialTheme.typography.bodyLarge,
        color = PrimaryColor
    )
}

@Composable
fun DescriptionText(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray
    )
}

@Composable
fun FooterRow(answers: Int, date: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        AnswersRow(answers = answers)
        Text(text = date, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun AnswersRow(answers: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.documents),
            contentDescription = "Answers Icon",
            tint = PrimaryColor
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "$answers answers", color = Color.Gray, fontSize = 12.sp)
    }
}

