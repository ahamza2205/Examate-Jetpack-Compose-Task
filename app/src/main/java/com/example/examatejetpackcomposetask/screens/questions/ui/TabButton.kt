package com.example.examatejetpackcomposetask.screens.questions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor

@Composable
fun TabButton(title: String, selectedTab: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val iconRes = if (title == "Writing") R.drawable.write else R.drawable.oral
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "$title Icon",
                tint = if (title == selectedTab) PrimaryColor else SecondaryColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                color = if (title == selectedTab) PrimaryColor else SecondaryColor,
                fontWeight = FontWeight.Bold
            )
        }
        if (title == selectedTab) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(2.dp)
                    .background(PrimaryColor)
            )
        }
    }
}


