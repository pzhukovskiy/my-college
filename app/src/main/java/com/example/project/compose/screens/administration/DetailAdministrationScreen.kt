package com.example.project.compose.screens.administration

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.administrators.Administrator

@Composable
fun DetailAdministrationScreen(
    administrator: Administrator,
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
                    text = "${administrator.middle_name} ${administrator.first_name[0]}. ${administrator.last_name[0]}.",
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
                        model = administrator.image,
                        contentDescription = administrator.toString(),
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(text = administrator.description, modifier = Modifier.padding(horizontal = 4.dp))
                Text(text = administrator.second_description, modifier = Modifier.padding(horizontal = 4.dp))
                Spacer(modifier = Modifier.height(45.dp))
            }
        }
    )
}