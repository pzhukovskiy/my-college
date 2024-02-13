package com.example.project.compose.screens.about_college.year_2022

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
fun Year2022(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "2022 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/45393/img/%D0%9F%D1%80%D0%BE%D0%BA%D1%83%D1%80%D0%BE%D1%80.jpg)
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/45393/img/%D1%81%D1%82%D1%80%D0%BE%D0%B9%D0%BE%D1%82%D1%80%D1%8F%D0%B4.jpg)
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
                        - на III этапе республиканской олимпиады по общеобразовательным предметам Диплома I степени Комитета по образованию Мингорисполкома удостоен учащийся колледжа Лубенцов Максим Иванович (учебная группа 64ТП) — «География» (преподаватель Поклад Татьяна Ивановна); Диплома II степени Комитета по образованию Мингорисполкома удостоен учащийся колледжа Совко Даниил Викторович (учебная группа 66ТП) — «Всемирная история. История Беларуси» (преподаватель Галенко Елена Львовна); 
                        - учащийся колледжа Леонов Тимофей занял II место в спартакиаде детско-юношеских спортивных школ по стрельбе пулевой;
                        - учащийся колледжа Одинец Прохор одержал победу в Международном конкурсе классической музыки «Viva music»;
                        - учащаяся колледжа Романюк Диана удостоена Диплома II степени в городском конкурсе детско-юношеских СМИ "Изменим мир к лучшему!" (в номинации "Лучший авторский материал", руководитель Громыко Н.К.);
                        - по итогам заключительного этапа республиканской олимпиады по учебному предмету "География" учащийся колледжа Лубенцов Максим удостоен Диплома III степени Министерства образования Республики Беларусь;
                        - 28 января директор колледжа Козел Г.В. принял участие в Послании Президента Республики Беларусь белорусскому народу и Национальному собранию, проходившему во Дворце Республики;
                        - 4 марта директор колледжа Козел Г.В. принял участие в Торжественной церемонии подписания Президентом Республики Беларусь Решения республиканского референдума, проходившему во Дворце Независимости;
                        - команда колледжа под руководством Дышко В.А., Липеня А.В., Петуховского М.С., Потеса Р.И., Пугача А.И., Тишкова М.И. удостоена Дипломов II и III степени в Республиканском смотре инновационного и технического творчества учащихся и работников учреждений образования;
                        - 16 марта состоялась встреча обучающихся и педагогов колледжа с Генеральным прокурором Республики Беларусь Шведом А.И. В рамках мероприятия Андрей Иванович ознакомился с организацией образовательного процесса, в том числе с процессом обучения учащихся с особыми образовательными потребностями с помощью современных средств обучения;
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