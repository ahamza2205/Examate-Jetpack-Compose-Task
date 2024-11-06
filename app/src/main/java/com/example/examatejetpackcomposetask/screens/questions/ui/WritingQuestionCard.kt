package com.example.examatejetpackcomposetask.screens.questions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SurfaceColor
import androidx.compose.ui.graphics.Color
import com.example.examatejetpackcomposetask.screens.questions.domain.Question
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor

@Composable
fun WritingQuestionCard(question: Question) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            CategoryRow(category = question.category)
            Spacer(modifier = Modifier.height(4.dp))
            TaskText(task = question.task)
            Spacer(modifier = Modifier.height(8.dp))
            FooterRow(date = question.date, description = question.description)
            Spacer(modifier = Modifier.height(8.dp))
            ProgressBar(progress = question.progress)
        }
    }
}

@Composable
fun CategoryRow(category: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = getIconForCategoryDrawable(category)),
            contentDescription = "Category Icon",
            tint = PrimaryColor
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = category,
            style = MaterialTheme.typography.bodyLarge,
            color = PrimaryColor
        )
    }
}

@Composable
fun TaskText(task: String) {
    Text(
        text = task,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Gray
    )
}

@Composable
fun FooterRow(date: String, description: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = date, color = Color.Gray, fontSize = 12.sp)
        Text(text = description, color = PrimaryColor, fontSize = 12.sp)
    }
}

@Composable
fun ProgressBar(progress: Int) {
    val progressFraction = progress / 100f

    Box(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .background(SecondaryColor)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(progressFraction)
                .height(6.dp)
                .background(PrimaryColor)
        )
    }
}

fun getIconForCategoryDrawable(category: String): Int {
    return when (category) {
        "Voyage", "Immigration", "Travel" -> R.drawable.travel
        "Technology" -> R.drawable.technology
        "Art & Culture" -> R.drawable.art
        "Environment" -> R.drawable.environment
        else -> R.drawable.question
    }
}
