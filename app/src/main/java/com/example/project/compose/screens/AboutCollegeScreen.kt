package com.example.project.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget

@Composable
fun AboutCollegeScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        content = { paddingValues ->
            Column {
                StaticHeaderWidget(
                    text = "О колледже",
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )

                Text(text = "text", modifier = Modifier.padding(paddingValues))
            }
        }
    )
}