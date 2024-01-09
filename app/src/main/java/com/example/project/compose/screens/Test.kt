package com.example.project.compose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project.viewmodels.TeacherViewModel

@Composable
fun TestScreen(
    viewModel: TeacherViewModel
) {
    var query by remember { mutableStateOf("") }
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        if (viewModel.errorMessage.isBlank()) {
            viewModel.getTeacher()
        }
    }

    Scaffold { paddingValues ->
        if (viewModel.errorMessage.isBlank()) {
            Column(modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
            ) {
                TextField(
                    value = query,
                    onValueChange = {
                        query = it
                        viewModel.filterTeacherByFIO(it)
                    },
                    label = { Text("Search") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                )
                LazyColumn(content = {
                    items(viewModel.filteredTeacherList) { teacher ->
                        AsyncImage(
                            model = teacher.image,
                            contentDescription = teacher.last_name,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(16.dp))
                                .clickable {
                                    // Handle click on image
                                }
                                .padding(top = 2.5.dp, bottom = 2.5.dp)
                        )
                    }
                })
            }
        } else {
            ConnectionErrorComponent {
                if (viewModel.isConnected()) {
                    isRefreshing = true
                    viewModel.fetchData()
                }
            }
        }
    }
}