package com.example.examatejetpackcomposetask.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.examatejetpackcomposetask.ui.theme.PrimaryColor
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor

@Composable
fun FullScreenTutorialDialog(onDismiss: () -> Unit, onNextStep: () -> Unit) {
    Dialog(onDismissRequest = {
        onDismiss()
        onNextStep()
    }) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .clickable {
                    onDismiss()
                    onNextStep()
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to: How to use and enjoy Examate",
                    color = SecondaryColor,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Tap anywhere on the screen to continue",
                    color = PrimaryColor,
                    fontSize = 20.sp
                )
            }
        }
    }
}


