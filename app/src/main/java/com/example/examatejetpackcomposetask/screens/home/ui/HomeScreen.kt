package com.example.examatejetpackcomposetask.screens.home.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.home.presentation.StudyUnitViewModel
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography

@Composable
fun HomeScreen(viewModel: StudyUnitViewModel = hiltViewModel()) {
    val studyUnits = viewModel.studyUnits.collectAsState().value

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

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
