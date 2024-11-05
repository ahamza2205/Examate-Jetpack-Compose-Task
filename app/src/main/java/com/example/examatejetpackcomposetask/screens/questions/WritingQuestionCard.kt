package com.example.examatejetpackcomposetask.screens.questions

import Question
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.ui.graphics.Color
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor

@Composable
fun WritingQuestionCard(question: Question) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = SurfaceColor
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = getIconForCategoryDrawable(question.category)),
                    contentDescription = "Category Icon",
                    tint = PrimaryColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = question.category,
                    style = MaterialTheme.typography.bodyLarge,
                    color = PrimaryColor
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = question.task,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = question.date, color = Color.Gray, fontSize = 12.sp)
                Text(text = " ${question.description}", color = PrimaryColor, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Calculate progress fraction
            val progressFraction = question.progress / 100f

            Box(modifier = Modifier.fillMaxWidth()) {
                // Background for uncompleted progress
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(SecondaryColor)
                )
                // Foreground for completed progress
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progressFraction)
                        .height(6.dp)
                        .background(PrimaryColor)
                )
            }
        }
    }
}

fun getIconForCategoryDrawable(category: String): Int {
    return when (category) {
        "Voyage" -> R.drawable.travel
        "Immigration" -> R.drawable.travel
        "Technology" -> R.drawable.technology
        "Art & Culture" -> R.drawable.art
        "Environment" -> R.drawable.environment
        "Travel" -> R.drawable.travel
        else -> R.drawable.question
    }
}
