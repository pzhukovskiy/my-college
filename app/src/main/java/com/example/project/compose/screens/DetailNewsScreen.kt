package com.example.project.compose.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.project.data.news.News

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

        Text(text = news.description)

        //Build only with TIRAMISU SDK
//        SendNotificationWidget()
    }
}