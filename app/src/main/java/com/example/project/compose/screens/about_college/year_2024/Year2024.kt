package com.example.project.compose.screens.about_college.year_2024

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
fun Year2024(
    onBackClick: () -> Unit
) {
    Column {
        StaticHeaderWidget(
            text = "2024 год",
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
                        За образцовое выполнение своих обязанностей и активное участие в создании инклюзивной образовательной среды отмечены наградами следующие работники колледжа:
                        Благодарностью Мингорисполкома: Бондарь Светлана Леонтьевна, Берговина Анастасия Владимировна, Леус Жанна Владимировна.
                        Почетной грамотой администрации Октябрьского района: Яськова Галина Ивановна, Коршак Татьяна Антоновна, Луговцова , Кульбеда Максим Павлович, Левонюк Елизавета Анатольевна, Протасеня Анастасия Олеговна.
                        Благодарностью администрации Октябрьского района: Ключник Людмила Александровна, Абрамович Николай Вячеславович, Артюх Светлана Степановна, Баева Зинаида Викторовна, Буденец Светлана Петровна, Василевич Наталья Анатольевна, Дедюля Валентина Анатольевна, Живоглод Михаил Иванович, Заболоцкая Татьяна Михайловна, Солтан-Михолап Ирина Васильевна, Чаюк Елена Адамовна.
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