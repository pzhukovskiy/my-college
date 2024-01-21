package com.example.project.compose.screens.news

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.project.data.news.News
import com.example.project.ui.theme.Roboto

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("QueryPermissionsNeeded")
@Composable
fun DetailNewsScreen(
    news: News,
    onBackClick: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        StaticHeaderWidget(
            text = news.title,
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = onBackClick
        )

        Box(
            modifier = Modifier
                .height(400.dp)
        ) {
            AsyncImage(
                model = news.image,
                contentDescription = news.title,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = news.main_text,
            fontFamily = Roboto,
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(500),
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(45.dp))
    }
}