package com.example.project.compose.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarWidget() {
    Box(
       modifier = Modifier
           .height(80.dp)
           .fillMaxWidth()
           .background(Color.LightGray)
           .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = "text")
    }
    Spacer(modifier = Modifier.padding(20.dp))
}