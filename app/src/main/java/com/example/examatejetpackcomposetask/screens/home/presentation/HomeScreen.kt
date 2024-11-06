package com.example.examatejetpackcomposetask.screens.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.examatejetpackcomposetask.BottomNavigation.BottomNavItem
import com.example.examatejetpackcomposetask.R
import com.example.examatejetpackcomposetask.screens.home.domain.StudyUnit
import com.example.examatejetpackcomposetask.screens.home.ui.StudyUnitItem
import com.example.examatejetpackcomposetask.screens.home.ui.VerticalDivider
import com.example.examatejetpackcomposetask.tutorial.FullScreenTutorialDialog
import com.example.examatejetpackcomposetask.tutorial.TutorialDialog
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.Typography

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: StudyUnitViewModel = hiltViewModel()
) {
    val studyUnits = viewModel.studyUnits.collectAsState().value


    var showTutorial by remember { mutableStateOf(true) }
    var showNavBarTutorial by remember { mutableStateOf(false) }


    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        // Show full-screen tutorial
        if (showTutorial) {
            FullScreenTutorialDialog(
                onDismiss = { showTutorial = false },
                onNextStep = { showNavBarTutorial = true },
            )
        }
        // Show navigation tutorial
        if (showNavBarTutorial) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                TutorialDialog(
                    text = "Vous trouverez ici votre plan d'étude",
                    alignment = Alignment.BottomStart,
                    onDismiss = { showNavBarTutorial = false },
                    onNextStep = {
                        showNavBarTutorial = false
                        // Navigate to the "Connect" screen
                        navController.navigate(BottomNavItem.Connect.route) {
                            popUpTo(BottomNavItem.Home.route) { inclusive = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    offsetX = -10.dp,
                    offsetY = -75.dp
                )
            }
        }

        // Column layout containing the header, greeting, and study plan sections
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            HomeScreenHeader()
            GreetingSection()
            StudyPlanSection(studyUnits)
        }
    }
}

@Composable
fun HomeScreenHeader() {
    // Header section with "Home" title and notification icon
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
}

@Composable
fun GreetingSection() {
    // Section displaying greeting text and "Study Plan" heading
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
}

@Composable
fun StudyPlanSection(studyUnits: List<StudyUnit>) {
    // Loop through each study unit and display it as a row
    studyUnits.forEachIndexed { index, unit ->
        StudyUnitRow(unit, showDividerBelow = index < studyUnits.size - 1)
    }
}

@Composable
fun StudyUnitRow(unit: StudyUnit, showDividerBelow: Boolean) {
    // Layout for each study unit with a divider if it's not the last item
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Display study unit item
            StudyUnitItem(unit)

            // Show a divider below if `showDividerBelow` is true
            if (showDividerBelow) {
                VerticalDivider(color = if (unit.isLocked) SecondaryColor else PrimaryColor)
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Display study unit details (title and subtitle)
        StudyUnitDetails(unit)
    }
}

@Composable
fun StudyUnitDetails(unit: StudyUnit) {
    // Column layout to show details of each study unit
    Column {
        Text(
            text = unit.title,
            style = Typography.bodyLarge.copy(fontSize = 24.sp),
            color = if (unit.isLocked) SecondaryColor else PrimaryColor
        )
        // Display subtitle if it exists
        if (unit.subtitle.isNotEmpty()) {
            Text(
                text = unit.subtitle,
                style = Typography.labelSmall.copy(
                    fontSize = 18.sp,
                    color = if (unit.isLocked) SecondaryColor else PrimaryColor
                )
            )
        }
    }
}
