package com.example.examatejetpackcomposetask.BottomNavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examatejetpackcomposetask.screens.connect.presentation.ConnectScreen
import com.example.examatejetpackcomposetask.screens.home.presentation.HomeScreen
import com.example.examatejetpackcomposetask.screens.profile.ProfileScreen
import com.example.examatejetpackcomposetask.screens.questions.presentation.QuestionsScreen
import com.example.examatejetpackcomposetask.screens.tools.ToolsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen(navController = navController) }
            composable(BottomNavItem.Connect.route) { ConnectScreen(navController = navController) }
            composable(BottomNavItem.Questions.route) { QuestionsScreen() }
            composable(BottomNavItem.Tools.route) { ToolsScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
        }
    }
}

