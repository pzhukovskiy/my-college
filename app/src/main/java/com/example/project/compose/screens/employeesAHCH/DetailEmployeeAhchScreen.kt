package com.example.project.compose.screens.employeesAHCH

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.employeesahch.EmployeeAHCH
import com.example.project.ui.theme.Roboto

@Composable
fun DetailEmployeeAhchScreen(
    employeeAhch: EmployeeAHCH,
    onBackClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {

                StaticHeaderWidget(
                    text = "${employeeAhch.middle_name} ${employeeAhch.first_name[0]}. ${employeeAhch.last_name[0]}.",
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )

                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .height(450.dp)
                ) {
                    AsyncImage(
                        model = employeeAhch.image,
                        contentDescription = employeeAhch.toString(),
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = employeeAhch.description,
                    fontFamily = Roboto,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(45.dp))
            }
        }
    )
}