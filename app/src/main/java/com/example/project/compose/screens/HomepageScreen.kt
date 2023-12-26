package com.example.project.compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.AnimatedHeaderWidget

//scrollState.maxValue == 1423

@Composable
fun HomepageScreen() {
    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.king_kohli),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }

        AnimatedHeaderWidget(
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            text = stringResource(R.string.main_page),
            scrollState = scrollState
        )
    }
}