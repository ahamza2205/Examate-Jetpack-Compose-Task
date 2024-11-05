package com.example.examatejetpackcomposetask.BottomNavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.examatejetpackcomposetask.ui.theme.BackgroundColor
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor
import com.example.examatejetpackcomposetask.ui.theme.SurfaceColor


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Connect,
        BottomNavItem.Questions,
        BottomNavItem.Tools,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = SurfaceColor,
        contentColor = SecondaryColor,
        modifier = Modifier.height(75.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.label
                        )
                        Text(text = item.label)
                    }
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = PrimaryColor,
                unselectedContentColor = SecondaryColor
            )
        }
    }
}

