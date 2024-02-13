package com.example.project.compose.screens.about_college.year_1980

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
fun Year1980(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "1980 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/42183/img/sm_full.aspx-guid=156843.jpg)
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
                        - Президиум Минского областного совета профсоюзов наградил Почетной Грамотой директора училища Олейникова Я.Ф.;
                        - мастеру производственного обучения Букланову В.И. вручены Почетная грамота Минского областного комитета профсоюза рабочих радиоэлектронной промышленности и Почетная грамота Государственного комитета СССР по профессионально-техническому образованию;
                        - председатель профсоюзной организации учащихся училища Овчинников И.И. награжден Почетной грамотой Минского областного совета профсоюзов;
                        - училищу вручена Почетная грамота Государственного комитета БССР по профессионально-техническому образованию за II место по итогам социалистического соревнования за III квартал 1980 года и первого этапа соревнования по достойной встрече XXVI съезда КПСС;
                        - на Выставке достижений народного хозяйства СССР представлена разработка тренажера для подготовки сварщиков полупроводниковых приборов и микросхем, выполненная учащимися Александром Варнавским, братьями Игорем и Сергеем Сытенковыми и Сергеем Делендиком под руководством мастеров производственного обучения А.А. Табакова и Букланова В.И. Экспонат был удостоен Диплома ЦК ВЛКСМ, Госкомитета СССР по науке и технике, Центрального Совета ВОИР, Всесоюзного совета НТО, а педагоги стали лауреатами Всесоюзного смотра научно-технического творчества молодежи;
                        - мастеру производственного обучения А.А. Табакову вручена Золотая медаль Выставки достижений народного хозяйства СССР;
                        - мастер производственного обучения Полторжицкий Л.Б. награжден бронзовой медалью Выставки достижений народного хозяйства СССР;
                        - по данным базового предприятия НПО «Интеграл» за годы деятельности училища подготовлено 50 специалистов, удостоенных государственных наград за доблестный труд;
                        ---
                        """.trimIndent(),
                )
            }
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/42183/img/sm_full.aspx-guid=156883.png)
                        """.trimIndent(),
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                    )
                    MarkdownText(
                        markdown = """
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/42183/img/sm_full.aspx-guid=156873.jpg)
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
                        - команда училища принимает участие в спортивном празднике, посвященном открытию Олимпиады – 80;
                        - в соревновании за звание «Лучшее училище системы Государственного комитета Совета Министров СССР по профессионально-техническому образованию» училище награждено Дипломом I степени и Дипломом Всесоюзного Центрального Совета Профессиональных союзов СССР;
                        - издано пособие «Производственное обучение сварщиков полупроводниковых приборов» работников училища Хасина В.М. и Сиротина В.М.;
                        - заместитель директора училища Хасин В.М. избран депутатом Минского городского совета народных депутатов.
                        ---
                        """.trimIndent(),
                )
            }
            item {
                MarkdownText(
                    markdown = """
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/42183/img/sm_full.aspx-guid=156863.jpg)
                        """.trimIndent(),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(35.dp))
            }
        }
    }
}