package com.example.project.compose.screens

import android.annotation.SuppressLint
import android.content.Context
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
import com.example.project.compose.widgets.EmailButtonWidget
import com.example.project.compose.widgets.SendNotificationWidget
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.compose.widgets.TelephoneButtonWidget
import com.example.project.data.news.NewsInfo

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "QueryPermissionsNeeded")
@Composable
fun DetailNewsScreen(
    context: Context,
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

        EmailButtonWidget(context = context)

        TelephoneButtonWidget(context = context)

        //Build only with TIRAMISU SDK
        SendNotificationWidget()
    }
}