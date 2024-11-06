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

@Composable
fun StudyUnitItem(unit: StudyUnit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        OuterCircleFrame(isLocked = unit.isLocked) {
            InnerCircleContent(unit)
        }
        VerticalDivider(color = if (unit.isLocked) SecondaryColor else PrimaryColor)
    }
}

@Composable
fun OuterCircleFrame(isLocked: Boolean, content: @Composable () -> Unit) {
    val frameColor = if (isLocked) SecondaryColor else PrimaryColor
    val borderColor = if (isLocked) SecondaryColor else PrimaryColor

    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(frameColor)
            .border(
                width = 4.dp,
                color = borderColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
@Composable
fun InnerCircleContent(unit: StudyUnit) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        if (unit.isLocked) {
            Icon(
                painter = painterResource(id = R.drawable.lock),
                contentDescription = "Locked",
                tint = SecondaryColor,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Text(
                text = unit.number.toString(),
                color = PrimaryColor,
                fontSize = 28.sp
            )
        }
    }
}

@Composable
fun VerticalDivider(color: Color) {
    Box(
        modifier = Modifier
            .width(12.dp)
            .height(25.dp)
            .background(color)
    )
}
