package com.example.project.compose.screens.about_college.info_1966

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget

@Composable
fun Info1966(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = stringResource(id = R.string.about_college_1966),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )
        Text(text = stringResource(id = R.string.about_college_1966_1), modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
        Text(text = stringResource(id = R.string.about_college_1966_2), modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
    }
}