package com.example.project.compose.screens.about_college.year_1969

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun Year1969(
    onBackClick: () -> Unit
) {

    Column {
        StaticHeaderWidget(
            text = "1969 год",
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .fillMaxWidth(),
        ) {
            item {
                MarkdownText(
                    markdown = """
                        ---
                        - за высокопрофессиональную подготовку рабочих кадров училище получило статус цеха №1 НПО «Интеграл». Это был первый шаг признания в СССР значимости подготовки рабочих кадров для передовых отраслей народного хозяйства;
                        - коллективу училища вручена Почетная грамота Государственного комитета Совета Министров СССР по профессионально-техническому образованию.
                        ---
                        """.trimIndent(),
                )
            }
            item {
                Spacer(modifier = Modifier.height(35.dp))
            }
        }
    }
}