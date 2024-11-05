package com.example.examatejetpackcomposetask.screens.connect.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examatejetpackcomposetask.ui.theme.SecondaryColor

@Composable
fun InfoIcon(resourceId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = contentDescription,
        modifier = Modifier.size(20.dp),
        colorFilter = ColorFilter.tint(SecondaryColor)
    )
}