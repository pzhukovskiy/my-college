package com.example.project.compose.screens.about_college.year_2023

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
fun Year2023(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "2023 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/47223/img/2222.JPG)
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/47223/img/27-12-22.jpg)
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
                        - учащийся колледжа Раткевич Юрий одержал победу на отборочном туре городского этапа V Республиканского конкурса профессионального мастерства «WORLDSKILLS» в компетенции «Программные решения для бизнеса» (эксперт Кулецкая Ю.Н.);
                        - команда колледжа заняла I место в городских соревнованиях по волейболу в программе городской спартакиады обучающихся колледжей в 2022/2023 учебном году;
                        - учащиеся колледжа Костюк Алексей и Леус Ева удостоены дипломов II степени за участие в городском этапе республиканского конкурса научно-технического творчества «ТехноИнтеллект 2023» секция: «Информационные системы и технологии» руководитель Леус Жанна Владимировна;
                        - учащийся колледжа Совко Даниил победил на третьем этапе республиканской олимпиады по учебным предметам «Всемирная история» и «История Беларуси» в 2022/2023 учебном году и получил диплом II степени (руководитель Галенко Е.Л.);
                        - команда колледжа заняла II место в городских соревнованиях по зимнему многоборью «Здоровье» среди юношей в рамках 47-й спартакиады среди учащихся учреждений профессионально-технического и среднего специального образования;
                        - 7 и 10 февраля в рамках третьего этапа конкурса молодежных инициатив «Минская смена 2023» учащиеся колледжа Пожарицкий Максим и Лукша Евгений представили свои проекты на встрече с городской администрацией;
                        - творческая группа учащихся колледжа приняла участие в Всероссийских литературно-краеведческих чтениях «Здравствуй, тихая родина!» и награждена Сертификатами и Дипломами I и II степени;
                        - 22 февраля на базе колледжа состоялся круглый стол с участием Уполномоченного по делам религии и национальностей А.Румаком, заместителем Министра образования Республики Беларусь А.Кадлубаем, заместителем председателя Мингорисполкома А.Цураном, руководителями основных религиозных конфессий и национальных диаспор по теме "План совместных мероприятий в Год мира и созидания";
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