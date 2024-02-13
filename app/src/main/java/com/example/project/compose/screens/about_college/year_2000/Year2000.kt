package com.example.project.compose.screens.about_college.year_2000

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
fun Year2000(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "2000 год",
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
                        ![Image](https://mgkct.minskedu.gov.by/files/02049/obj/140/45193/img/5.jpg)
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
                        - мастер производственного обучения Босянок Г.Ф. стала призером I городского конкурса производственного мастерства «Мастер года 2000»;
                        - победителем республиканского конкурса пользователей ЭВМ стал Михаил Столяров. Удостоен звания Лауреата Специального Фонда Президента Республики Беларусь по социальной поддержке талантливой молодежи (преподаватель Дзевенский Э.М.);
                        - победителем Республиканской олимпиады по информатике стал Алексей Пузенко. Удостоен звания Лауреата Специального Фонда Президента Республики Беларусь по социальной поддержке талантливой молодежи (преподаватель Дзевенский Э.М.);
                        - Грамотой Министерства образования Республики Беларусь награжден Пугач А.И.;
                        - преподаватель спецдисциплин Дзевенская Р.И. награждена нагрудным Знаком «Отличник образования Республики Беларусь»;
                        - Почетной Грамотой Управления образования Мингорисполкома награждены Дудко Алла Романовна и Дернейко Александр Степанович;
                        - открыт музей-кабинет им. В. Короткевича (создатель Жолнерович П.П.);
                        - преподаватель Громыко Н.К. стала финалистом городского конкурса «Столичный учитель-столичному образованию» в номинации «Куратор года».
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