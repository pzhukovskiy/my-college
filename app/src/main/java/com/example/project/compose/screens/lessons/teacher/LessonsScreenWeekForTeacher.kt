package com.example.project.compose.screens.lessons.teacher

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
import com.example.project.viewmodels.LessonsViewModel

@Composable
fun LessonsScreenWeekForTeacher(
    viewModel: LessonsViewModel,
    navController: NavController
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchLessonsForWeekTeacher()
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
        // Показывать расписание в LazyColumn
        LazyColumn(content = {
            items(viewModel.lessonsList) { lesson ->
                Text(text = "id: ${lesson.id}", modifier = Modifier.padding(it))
                Text(text = "Группа: ${lesson.group.group}, id: ${lesson.group.id}")
                Text(text = "Предмет: ${lesson.subject.subject}")
                Text(text = "Преподаватель: ${lesson.teacher.first_name} ${lesson.teacher.last_name}")
            }
        })
    }
}