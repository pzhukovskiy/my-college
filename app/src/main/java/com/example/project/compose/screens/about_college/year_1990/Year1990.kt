package com.example.project.compose.screens.about_college.year_1990

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
fun Year1990(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "1990 год",
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
                        - с июля 1990 года в течение восьми лет создавались студенческие отряды, работавшие в Крыму, Молдавии, Краснодарском крае. Командирами отрядов были: Романович С.Г., Табаков А.А., Хомченко И.И., Таркова Л.И., Шантрукова Г.Н., Вострикова Т.С., Максименков А.Г., Ананко Н.Н., Чуприс В.С., Букланов В.И., Темиров Р.А.;
                        - заведующая отделением Козыренко Г.В. награждена Почетной грамотой Минского обкома профсоюза рабочих радиоэлектронной промышленности;
                        - работники училища: Ахундова Л.А., Дуб Г.И., Белышева Т.Н.-удостоены нагрудного знака «Отличник профессионально-технического образования БССР».
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