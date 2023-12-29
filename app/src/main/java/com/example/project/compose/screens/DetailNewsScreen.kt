package com.example.project.compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.data.news.NewsInfo

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailNewsScreen(
    news: NewsInfo,
    onBackClick: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        StaticHeaderWidget(
            text = news.fields.title,
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = onBackClick
        )

        Text(text = news.fields.description)
    }
}