package com.example.project.compose.screens.about_college.year_1974

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
fun Year1974(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "1974 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/42123/img/sm_full.aspx-guid=156753.jpg)
                        """.trimIndent(),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp)
                )
            }
            item {
                MarkdownText(
                    markdown = """
                        ---
                        - по итогам социалистического соревнования за III и IV кварталы училище заняло I место в Минской области; за III квартал – III место, за IV квартал – II место в республике;
                        - приказом Государственного комитета Совета Министров Белорусской ССР по профессионально-техническому образованию училище преобразовано в «Минское техническое училище №76 – электроники»;
                        - училище заканчивает Анна Дмитриевна Шлапакова, Ударник коммунистического труда, сварщица НТО «Интеграл», награждена орденом «Знак Почета», Почетной Ленинской Грамотой, знаком «Ударник XX пятилетки». Избиралась депутатом Верховного Совета СССР;
                        - за I место среди училищ Минской области по итогам социалистического соревнования за III и IV кварталы училище награждено Почетной грамотой Государственного комитета Совета Министров БССР по профессионально-техническому образованию;
                        - укрепилась традиция приема на педагогическую работу в училище выпускников. В 1974 году на работу мастерами производственного обучения принято 15 выпускников, которые впоследствии долгие годы работали в училище.
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