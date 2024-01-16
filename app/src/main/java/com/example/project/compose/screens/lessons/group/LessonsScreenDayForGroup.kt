package com.example.project.compose.screens.lessons.group

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.project.viewmodels.SharedViewModel
import com.example.project.viewmodels.LessonsViewModel

@Composable
fun LessonsScreenDayForGroup(
    viewModel: SharedViewModel,
    lessonsViewModel: LessonsViewModel,
    navController: NavController
) {

    val sharedValue = viewModel.sharedValue.value

    //lesson id
    LaunchedEffect(key1 = Unit) {
        lessonsViewModel.fetchLessonsGroup(id = sharedValue)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Расписание") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        LazyColumn(content = {
            items(lessonsViewModel.lessonsList) { lesson ->
                Text(text = "id: ${lesson.id}", modifier = Modifier.padding(it))
                Text(text = "Группа: ${lesson.group.group}, id: ${lesson.group.id}")
                Text(text = "Предмет: ${lesson.subject.subject}")
                Text(text = "Дата: ${lesson.date}")
                Text(text = "Преподаватель: ${lesson.teacher.first_name} ${lesson.teacher.last_name}")
            }
        })
    }
}