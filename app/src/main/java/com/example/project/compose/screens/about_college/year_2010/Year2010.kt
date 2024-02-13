package com.example.project.compose.screens.about_college.year_2010

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
fun Year2010(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "2010 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/45273/img/1.jpg)
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/45273/img/2.jpg)
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
                        - победителем городского конкурса профессионального мастерства «Столичный учитель – столичному образованию 2010» в номинации «Классный руководитель (куратор группы)» стала преподаватель физики, куратор группы Лебедкина Н.В. В журнале «Минская школа» опубликовано интервью с победительницей и ее конкурсные материалы;
                        - победителем городского конкурса методических служб среди учреждений, обеспечивающих получение профессионально-технического и среднего специального образования, стала методическая служба колледжа (методист Дедюля С.Н.). Методическая служба колледжа, ее активные соратники удостоены Гран-при конкурса;
                        - мастер производственного обучения Гурский Д.С., заведующий мастерской операторов ЭВМ, признан призером городского конкурса на лучшую учебную мастерскую учреждений профессионально-технического образования. Награжден Дипломом II степени;
                        - состоялся выход в финал участницы конкурса красоты «Европа-2010» от Республики Беларусь (среди неслышащих девушек) Илоны Ермолик, учащейся колледжа;
                        - в 13 номере выпуска газеты «Вечерний Минск» опубликована статья «Поколение электронщиков», посвященная успешной работе колледжа со своими социальными партнерами – предприятиями-заказчиками;
                        - сборная команда колледжа стала победителем ХХ туристического слета среди профессионально-технических учебных заведений столицы;
                        - заведующий центром профессиональной и социальной реабилитации для лиц с особенностями психофизического развития Романович С.Г. награждена Почетной грамотой Комитета по образованию Мингорисполкома и Почетной грамотой Минского городского комитета Белорусского профессионального союза работников образования и науки;
                        - директор колледжа Хасин В.М. награжден Дипломом Министерства образования Республики Беларусь за активное участие в подготовке и проведении Республиканской выставки-ярмарки «Город мастеров», посвященной 70-летию создания государственной системы профессионально-технического образования;
                        - в республиканском конкурсе художественно-политических программ «ПРОФ-БУМ» среди учащихся учреждений, обеспечивающих получение профессионально-технического образования, автор-исполнитель макета информационного стенда-плаката в номинации «Стремимся учиться, знать, уметь» Андрей Черепаха занял первое место;
                        - директор колледжа Хасин В.М. удостоен Диплома Лауреата международной премии имени А.Г. Неболсина Санкт-Петербургским Фондом профессионального образования;
                        - театр песни «Флэш» колледжа награжден Дипломами Министерства образования Республики Беларусь по результатам конкурса «АРТ-вакация». Коллективу вручены Дипломы I, II степени (руководитель Будько В.Ф.);
                        - Почетная грамота Комитета по образованию Мингорисполкома вручена Пугачу А.И. и Дзевенской Р.И.;
                        - победителем XII Республиканского слета изобретателей и рационализаторов стал Андрей Бацека. Награжден Дипломом I степени, удостоен звания Лауреата Специального Фонда Президента Республики Беларусь по социальной поддержке талантливой молодежи (мастер производственного обучения Гриневич П.Р.);
                        - Олег Щуцкий, учащийся колледжа, стал участником отборочного тура за право быть представленным в Международном музыкальном конкурсе «Новая волна» от Республики Беларусь;
                        - Вера Каретникова, выпускница колледжа, стала участницей отборочного тура за право быть представленной в Международном музыкальном конкурсе «Новая волна» от Республики Беларусь;
                        - лауреатами ежегодного международного медиафестиваля «Голоса молодых за устойчивое развитие» на этапе республиканского конкурса стали Олег Щуцкий (видеоролик «Остановись!»), Раиса Иссаковна и Эдуард Михайлович Дзевенские (флэш-ролик «Люми обучает энергосбережению»). Победившие проекты колледжа названы среди лауреатов всемирного фестиваля «Молодые голоса ADOBE» в Канаде (2010 год);
                        - сборная команда колледжа стала победителем городских соревнований по зимнему многоборью среди учащихся профессионально-технических учебных заведений;
                        - участники городского открытого конкурса «Информационные технологии в системе столичного образования» Лебедкина Н.В., Дзевенская Р.И., Марцуль М.А. и Шавейко А.А. за разработку электронного средства обучения «Медиатека совместного объединения педагогов, родителей и учащихся «Экосуполка» в номинации «Электронное средство для организации воспитательной и внеклассной работы» отмечены Свидетельством участников конкурса с правом представления пособия в аналогичных конкурсах республиканского уровня;
                        - педагог-организатор Кондратенко Ю.В. награждена Дипломом Министерства образования Республики Беларусь за активное участие в заключительном этапе VI Республиканского фестиваля декоративно-прикладного творчества учащихся среди работников и учащихся учреждений образования – «Беларускi вянок»;
                        - команда девушек колледжа стала серебряным призером 34-й спартакиады учащихся профессионально-технических учебных заведений Столицы;
                        - преподаватель дисциплины «Основы социально-гуманитарных наук» Галенко Е.Л. удостоена Благодарности Главы администрации Октябрьского района г. Минска за добросовестный творческий подход к решению приоритетных задач обучения и воспитания;
                        - в рамках 7-й Международной выставки-конференции «Современные технологии обучения в компаниях и учебных организациях» в сборнике выпущены материалы преподавателя спецдисциплин Волчек Е.А. «Роль обратной связи в дистанционном обучении»;
                        - сертификат участников Национальной Интернет игры «Наша Беларусь» вручен команде учащихся и педагогов, преподавателю истории и обществоведения Шантрукову В.А., преподавателям спецдисциплин Дзевенскому Э.М. и Дзевенской Р.И. за высокие показатели и результативность в игре.
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