package com.example.project.compose.screens.schedule_time

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun ScheduleTimeScreen(
       onBackClick: () -> Unit
) {

    Column {

        StaticHeaderWidget(
            text = stringResource(id = R.string.link_calls),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )

        LazyColumn {
            item {
                MarkdownText(
                    markdown = """
                        
                        ## Расписание звонков теоретического обучения на 2023/2024 учебный год
                        
                        """.trimIndent(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
            item {
                MarkdownText(markdown = """
                        ## Расписание звонков (понедельник - пятница)

                            | Пара   | Время                           |
                            | ------ | ------------------------------- |
                            | 1 пара | (9:00 - 9:45) (9:55 - 10:40)    |
                            | 2 пара | (10:50 - 11:35) (11:55 - 12:40) |
                            | 3 пара | (13:00 - 13:45) (13:55 - 14:40) |
                            | 4 пара | (14:50 - 15:35) (15:45 - 16:30) |
                            | 5 пара | (16:40 - 17:25) (17:35 - 18:20) |
                            | 6 пара | (18:30 - 19:15) (19:25 - 20:10) |
                            
                        ## Расписание звонков (суббота)

                            | Пара   | Время                           |
                            | ------ | ------------------------------- |
                            | 1 пара | (9:00 - 9:45) (9:55 - 10:40)    |
                            | 2 пара | (10:50 - 11:35) (11:50 - 12:35) |
                            | 3 пара | (12:50 - 13:35) (13:45 - 14:30) |
                            | 4 пара | (14:40 - 15:25) (15:35 - 16:20) |
                            | 5 пара | (16:30 - 17:15) (17:25 - 18:10) |
                            | 6 пара | (18:20 - 19:05) (19:15 - 20:00) |
                """.trimIndent(),
                modifier = Modifier
                    .padding(vertical = 4.dp))
            }
            item {
                Spacer(modifier = Modifier.height(35.dp))
            }
        }
    }
}