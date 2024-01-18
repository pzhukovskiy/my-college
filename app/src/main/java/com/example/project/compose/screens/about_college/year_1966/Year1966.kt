package com.example.project.compose.screens.about_college.year_1966

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
fun Year1966(
    onBackClick: () -> Unit
) {

    Column {
        StaticHeaderWidget(
            text = "1966 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/41393/img/%D0%93%D0%B0%D1%80%D0%BC%D0%BE%D0%B7%D0%B0.jpeg)
                        """.trimIndent(),
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                    )
                    MarkdownText(
                        markdown = """
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/41393/img/sm_full.png)
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
                        - во исполнение постановления ЦК КПБ и Совета Министров БССР №127 от 24.03.1966 года наприказ базе завода имени Дзержинского создано «Техническое училище №76-электротехники»;
                        - директором училища назначен Александр Михайлович Гармоза – инициатор и организатор подготовки учащихся по новым специальностям, который заложил традиции и создал условия для активного участия педагогического коллектива и коллектива учащихся в Выставке достижений народного хозяйства СССР в Москве.- директором училища назначен Александр Михайлович Гармоза – инициатор и организатор подготовки учащихся по новым специальностям, который заложил традиции и создал условия для активного участия педагогического коллектива и коллектива учащихся в Выставке достижений народного хозяйства СССР в Москве.
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