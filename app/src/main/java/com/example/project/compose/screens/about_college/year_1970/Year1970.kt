package com.example.project.compose.screens.about_college.year_1970

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun Year1970(
    onBackClick: () -> Unit
) {

    Column {
        StaticHeaderWidget(
            text = "1970 год",
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .height(150.dp),
                    Arrangement.SpaceAround
                ) {
                    MarkdownText(
                        markdown = """
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/41423/img/156503.jpeg)
                        """.trimIndent(),
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                    )
                    MarkdownText(
                        markdown = """
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/41423/img/156513.jpeg)
                        """.trimIndent(),
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                    )
                }
            }
            item {
                MarkdownText(
                    markdown = """
                        ---
                        - мастер производственного обучения Олихвер В.А. награждена медалью «За доблестный труд»;
                        - становятся традиционными военно-патриотические мероприятия («Неделя памяти героев»), посвященные ветеранам Великой Отечественной войны;
                        - училище заканчивает Валентина Петровна Пикулик, прославленная работница НПО «Интеграл», удостоенная ордена «Знак Почета». Коллективом предприятия избиралась депутатом Верховного Совета БССР;
                        - техническая разработка «Магниторадиола «Эврика-70»», изготовленная в кружке техническогофото творчества училища завоевала Золотую медаль Выставки достижений народного хозяйства СССР;
                        - агиттеатр училища удостоен звания лауреата республиканского конкурса художественной самодеятельности;
                        - училищу вручена Почетная грамота Государственного комитета Совета Министров СССР по профессионально-техническому образованию.
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