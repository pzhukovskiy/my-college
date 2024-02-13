package com.example.project.compose.screens.teachers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.screens.connection.ConnectionErrorComponent
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.viewmodels.TeacherViewModel

@Composable
fun TeacherScreen(
    navController: NavHostController,
    viewModel: TeacherViewModel,
    onBackClick: () -> Unit
) {

    var isRefreshing by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }

    LaunchedEffect(key1 = Unit) {
        if (viewModel.errorMessage.isBlank()) {
            viewModel.getTeacher()
        }
    }

    Scaffold(
        content = { paddingValues ->
            if (viewModel.errorMessage.isBlank()) {
                Column {
                    StaticHeaderWidget(
                        text = "Педагогический состав",
                        imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                        onBackClick = {
                            onBackClick()
                        }
                    )

                    TextField(
                        value = query,
                        onValueChange = {
                            query = it
                            viewModel.filterTeacherByFIO(it)
                        },
                        label = { Text(stringResource(id = R.string.search_teacher)) },
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                            .fillMaxWidth()
                    )

                    LazyColumn(content = {
                        items(viewModel.filteredTeacherList) { teacher ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .padding(horizontal = 12.dp, vertical = 4.dp)
                            ) {
                                Row {
                                    Box(
                                        modifier = Modifier
                                            .weight(0.5f)
                                            .height(180.dp)
                                    ) {
                                        AsyncImage(
                                            model = teacher.image,
                                            contentDescription = teacher.toString(),
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(180.dp)
                                    ) {
                                        Column {
                                            Text(
                                                text = "${teacher.middle_name} ${teacher.first_name} ${teacher.last_name}",
                                                style = MaterialTheme.typography.body1,
                                                color = Color.Black,
                                                fontFamily = Roboto,
                                                fontStyle = FontStyle.Normal,
                                                fontWeight = FontWeight(500),
                                                modifier = Modifier.padding(start = 4.dp)
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(horizontal = 18.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Box(modifier = Modifier
                                                    .background(Color(PrimaryBlue.toArgb()))
                                                    .height(30.dp)
                                                    .fillMaxWidth()
                                                    .clickable {
                                                        navController.navigate("${NavigationItem.DetailTeacher.route}/${teacher.id}")
                                                    },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        text = stringResource(id = R.string.administration_detail_info),
                                                        style = MaterialTheme.typography.body2,
                                                        color = Color.White,
                                                        fontFamily = Roboto,
                                                        fontStyle = FontStyle.Normal,
                                                        fontWeight = FontWeight(500),
                                                        modifier = Modifier.padding(paddingValues)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        item {
                            Spacer(modifier = Modifier.height(45.dp))
                        }
                    })
                }
            }
            else {
                ConnectionErrorComponent {
                    if (viewModel.isConnected()) {
                        isRefreshing = true
                        viewModel.fetchData()
                    }
                }
            }
        }
    )
}