package com.example.project.compose.screens.lessons.teacher

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
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
import com.example.project.utils.CurrentDate
import com.example.project.viewmodels.SharedViewModel
import com.example.project.viewmodels.LessonsViewModel

@Composable
fun LessonsScreenDayForTeacher(
    lessonsViewModel: LessonsViewModel,
    viewModel: SharedViewModel,
    onBackClick: () -> Unit
) {

    val sharedValue = viewModel.sharedValue.value
    val teacherValue = viewModel.teacherValue.value

    //lesson id
    LaunchedEffect(key1 = Unit) {
        if (lessonsViewModel.errorMessage.isBlank()) {
            lessonsViewModel.fetchLessonsTeacher(id = sharedValue)
        }
    }

    if (lessonsViewModel.errorMessage.isBlank() && lessonsViewModel.lessonsList.isNotEmpty()) {
        Column {
            StaticHeaderWidget(
                text = teacherValue,
                imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                onBackClick = {
                    onBackClick()
                }
            )

            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${CurrentDate().dayOfWeekString[0].uppercaseChar() + CurrentDate().dayOfWeekString.substringAfter(CurrentDate().dayOfWeekString[0])}, ${CurrentDate().currentDayOfMonth}.${CurrentDate().currentMonth}.${CurrentDate().currentYear}",
                    fontFamily = Roboto,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(500)
                )
            }

            LazyColumn(content = {
                items(lessonsViewModel.lessonsList) { lesson ->
                    Divider()
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Column {
                            Text(
                                text = "№ ${lesson.lesson_number}",
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(700)
                            )
                            Text(
                                text = lesson.group.group,
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(400)
                            )
                            Text(
                                text = "${lesson.subject.subject}\n(${lesson.lesson_type})",
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(400)
                            )
                            Text(
                                text = lesson.room.room,
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(700)
                            )
                        }
                    }
                    Divider()
                }
                item {
                    Spacer(modifier = Modifier.height(50.dp))
                }
            })
        }
    }
    else {
        Column {

            StaticHeaderWidget(
                text = teacherValue,
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
                    text = "${CurrentDate().dayOfWeekString[0].uppercaseChar() + CurrentDate().dayOfWeekString.substringAfter(CurrentDate().dayOfWeekString[0])}, ${CurrentDate().currentDayOfMonth}.${CurrentDate().currentMonth}.${CurrentDate().currentYear}",
                    fontFamily = Roboto,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(500)
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Занятий на этот день не найдено",
                    fontFamily = Roboto,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(500)
                )
            }
        }
    }
}