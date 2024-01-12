package com.example.project.compose.screens.about_college.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project.R
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun ButtonWidget(
    navController: NavController,
    route: String,
) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .background(Color(PrimaryBlue.toArgb()))
            .clickable {
                navController.navigate(route)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.detail),
            fontFamily = Roboto,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(500),
        )
    }
}