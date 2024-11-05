package com.example.examatejetpackcomposetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.examatejetpackcomposetask.BottomNavigation.MainScreen
import com.example.examatejetpackcomposetask.ui.theme.ExamateJetpackComposeTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamateJetpackComposeTaskTheme {
                MainScreen()
            }
        }
    }
}

