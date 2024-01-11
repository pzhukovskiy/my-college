package com.example.project.compose.screens

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
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.viewmodels.NewsViewModel

@Composable
fun ListAllNewsScreen(
    viewModel: NewsViewModel,
    navController: NavController,
    onBackClick: () -> Unit
) {
    Scaffold() { paddingValues ->
        Column {
            StaticHeaderWidget(
                text = stringResource(id = R.string.link_archive_news),
                imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                onBackClick = {
                    onBackClick()
                }
            )
            LazyColumn(content = {
                items(viewModel.newsList) { news ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .weight(0.5f)
                                    .height(100.dp)
                            ) {
                                AsyncImage(
                                    model = news.image,
                                    contentDescription = news.date_create,
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
                                        text = news.title,
                                        style = MaterialTheme.typography.body1,
                                        color = Color.Black,
                                        fontFamily = Roboto,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight(500),
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                    Text(
                                        text = news.description,
                                        style = MaterialTheme.typography.body2,
                                        color = Color.Gray,
                                        fontFamily = Roboto,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight(400),
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
                                                navController.navigate("${NavigationItem.DetailNews.route}/${news.id}")
                                            },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = stringResource(id = R.string.news_detail),
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
}