package com.example.examatejetpackcomposetask.screens.home.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography

@Composable
fun StudyUnitItem(unit: StudyUnit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(if (unit.isLocked) SecondaryColor else PrimaryColor)
            .border(
                width = 4.dp,
                color = if (unit.isLocked) PrimaryColor else SecondaryColor,
                shape = CircleShape
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(if (unit.isLocked) SecondaryColor else PrimaryColor),
            contentAlignment = Alignment.Center
        ) {
            if (unit.isLocked) {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = "Locked",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                )
            } else {
                Text(
                    text = unit.number.toString(),
                    color = Color.White,
                    style = Typography.labelSmall.copy(fontSize = 58.sp)
                )
            }
        }
    }
}

@Composable
fun VerticalDivider() {
    Box(
        modifier = Modifier
            .width(12.dp)
            .height(25.dp)
            .background(SecondaryColor)
    )
}
