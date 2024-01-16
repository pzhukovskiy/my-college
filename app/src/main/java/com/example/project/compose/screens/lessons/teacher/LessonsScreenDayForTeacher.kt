package com.example.project.compose.screens.lessons.teacher

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.ui.theme.Roboto
import com.example.project.viewmodels.SharedViewModel
import com.example.project.viewmodels.LessonsViewModel
import java.time.LocalDate

@Composable
fun LessonsScreenDayForTeacher(
    lessonsViewModel: LessonsViewModel,
    viewModel: SharedViewModel,
    onBackClick: () -> Unit
) {

    val sharedValue = viewModel.sharedValue.value

    val currentDate = LocalDate.now()
    val currentDayOfMonth = currentDate.dayOfMonth
    val currentMonth = currentDate.month
    val currentDayOfWeek = currentDate.dayOfWeek

    val dayOfWeekString = currentDayOfWeek.getDisplayName(
        java.time.format.TextStyle.FULL,
        java.util.Locale.getDefault()
    )

    //lesson id
    LaunchedEffect(key1 = Unit) {
        if (lessonsViewModel.errorMessage.isBlank()) {
            lessonsViewModel.fetchLessonsTeacher(id = sharedValue)
        }
    }

    Scaffold(
        content = { paddingValues ->
            if (lessonsViewModel.errorMessage.isBlank()) {
                Column {
                    StaticHeaderWidget(
                        text = "Расписание на $currentDayOfMonth. $currentMonth",
                        imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                        onBackClick = {
                            onBackClick()
                        }
                    )

                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = dayOfWeekString[0].toUpperCase() + dayOfWeekString.substringAfter(dayOfWeekString[0]),
                            fontFamily = Roboto,
                            color = Color.Black,
                            fontSize = 32.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight(500)
                        )
                    }

                    LazyColumn(content = {
                        items(lessonsViewModel.lessonsList) { lesson ->
                            Text(text = "id: ${lesson.id}", modifier = Modifier.padding(paddingValues))
                            Text(text = "Группа: ${lesson.group.group}, id: ${lesson.group.id}")
                            Text(text = "Предмет: ${lesson.subject.subject}")
                            Text(text = "Преподаватель: ${lesson.teacher.first_name} ${lesson.teacher.last_name}")
                        }
                    })
                }
            }
        }
    )
}