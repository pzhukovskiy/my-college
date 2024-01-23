package com.example.project.compose.screens.lessons.group

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project.R
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.utils.CurrentDate
import com.example.project.viewmodels.SharedViewModel
import com.example.project.viewmodels.LessonsViewModel

@Composable
fun LessonsScreenDayForGroup(
    viewModel: SharedViewModel,
    lessonsViewModel: LessonsViewModel,
    onBackClick: () -> Unit,
    navController: NavController
) {

    val sharedValue = viewModel.sharedValue.value
    val groupValue = viewModel.groupValue.value

    //lesson id
    LaunchedEffect(key1 = Unit) {
        lessonsViewModel.fetchLessonsGroup(id = sharedValue)
    }

    if (lessonsViewModel.errorMessage.isBlank() && lessonsViewModel.lessonsList.isNotEmpty()) {
        Column {
            StaticHeaderWidget(
                text = groupValue,
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
                                text = "${lesson.subject.subject}\n(${lesson.lesson_type})",
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(400)
                            )
                            Text(
                                text = "${lesson.teacher.middle_name} ${lesson.teacher.first_name[0].uppercaseChar()}. ${lesson.teacher.last_name[0].uppercaseChar()}.",
                                fontFamily = Roboto,
                                color = Color(PrimaryBlue.toArgb()),
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(400),
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate("${NavigationItem.DetailTeacher.route}/${lesson.teacher.id}")
                                    }
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
                text = "$groupValue",
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