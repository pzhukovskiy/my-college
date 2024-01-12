package com.example.project.compose.widgets.slider

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project.data.news.News
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoSliderWidget(
    navController: NavHostController,
    newsList: List<News>,
    pagerState: PagerState,
) {
    val visibleNewsCount = 3

    if (newsList.size >= visibleNewsCount) {
        val visibleNews = newsList.takeLast(visibleNewsCount).reversed()
        val images = visibleNews.map { it.image }
        val pk = visibleNews.map { it.id }
        val title = visibleNews.map { it.title }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 12.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Новости колледжа",
                    fontFamily = Roboto,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(700),
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Смотреть все",
                    fontFamily = Roboto,
                    color = Color(PrimaryBlue.toArgb()),
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.clickable {
                        navController.navigate(NavigationItem.ListAllNews.route)
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center,
        ) {
                HorizontalPager(
                    pageCount = visibleNews.size,
                    state = pagerState,
                    key = { pk[it] },
                    pageSize = PageSize.Fill
                ) { index ->
                    Column(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("${NavigationItem.DetailNews.route}/${pk[index]}")
                            }
                    ) {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                        ) {
                            AsyncImage(
                                model = images[index],
                                contentDescription = pk[index].toString(),
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = title[index],
                                fontFamily = Roboto,
                                color = Color.Black,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight(500),
                            )
                        }
                    }
                }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .padding(horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(images.size) {
                    val color = if (pagerState.currentPage == it) Color(PrimaryBlue.toArgb()) else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(8.dp)
                    )
                }
            }
        }
    }
}