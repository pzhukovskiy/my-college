package com.example.project.compose.screens.about_college.info_1966

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget

@Composable
fun Info1966(
    onBackClick: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        StaticHeaderWidget(
            text = stringResource(id = R.string.about_college_1966),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )
        Image(
            painter = painterResource(id = R.drawable.garmoza),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            contentScale = ContentScale.Crop,
        )
        Text(text = stringResource(id = R.string.about_college_1966_1), modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
        Image(
            painter = painterResource(id = R.drawable.prikaz),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp),
            contentScale = ContentScale.Crop,
        )
        Text(text = stringResource(id = R.string.about_college_1966_2), modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))

        Spacer(modifier = Modifier.padding(45.dp))
    }
}