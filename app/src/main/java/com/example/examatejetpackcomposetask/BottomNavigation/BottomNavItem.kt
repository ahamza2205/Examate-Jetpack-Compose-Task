package com.example.examatejetpackcomposetask.BottomNavigation

import com.example.examatejetpackcomposetask.R

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.home, "Home")
    object Connect : BottomNavItem("connect", R.drawable.connect, "Connect")
    object Questions : BottomNavItem("questions", R.drawable.question, "Questions")
    object Tools : BottomNavItem("tools", R.drawable.tools, "Tools")
    object Profile : BottomNavItem("profile", R.drawable.profile, "Profile")
}


