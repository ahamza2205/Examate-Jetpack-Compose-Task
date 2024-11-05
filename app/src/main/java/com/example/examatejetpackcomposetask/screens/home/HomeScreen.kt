package com.example.examatejetpackcomposetask.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography

data class StudyUnit(
    val number: Int,
    val title: String,
    val subtitle: String,
    val isLocked: Boolean
)

@Composable
fun HomeScreen() {
    val studyUnits = listOf(
        StudyUnit(1, "Unite 1:", "what is examate", false),
        StudyUnit(2, "Unite 2:", "what is TCF", true),
        StudyUnit(3, "Writing Tasks", "", true),
        StudyUnit(4, "Oral Task", "", true)
    )

    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header with title and notification icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Home",
                    style = Typography.titleLarge.copy(fontSize = 32.sp, color = PrimaryColor)
                )
                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Notification",
                    tint = PrimaryColor,
                    modifier = Modifier.size(32.dp)
                )
            }

            Text(
                text = "Hi User Name",
                style = Typography.bodyLarge.copy(fontSize = 24.sp, color = PrimaryColor),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Study Plan",
                style = Typography.bodyLarge.copy(fontSize = 28.sp, color = PrimaryColor),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            studyUnits.forEachIndexed { index, unit ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 0.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (index > 0) {
                            VerticalDivider()
                        }

                        StudyUnitItem(unit)

                        if (index < studyUnits.size - 1) {
                            VerticalDivider()
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = unit.title,
                            style = Typography.bodyLarge.copy(fontSize = 24.sp),
                            color = if (unit.isLocked) SecondaryColor else PrimaryColor
                        )
                        if (unit.subtitle.isNotEmpty()) {
                            Text(
                                text = unit.subtitle,
                                style = Typography.labelSmall.copy(
                                    fontSize = 18.sp,
                                    color = SecondaryColor
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

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
