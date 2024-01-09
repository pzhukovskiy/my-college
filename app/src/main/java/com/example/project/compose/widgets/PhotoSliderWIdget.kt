package com.example.project.compose.widgets

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project.data.news.News
import com.example.project.navigation.NavigationItem

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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp),
            contentAlignment = Alignment.Center,
        ) {
            HorizontalPager(
                pageCount = visibleNews.size,
                state = pagerState,
                key = { pk[it] },
                pageSize = PageSize.Fill
            ) { index ->
                AsyncImage(
                    model = images[index],
                    contentDescription = pk[index].toString(),
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navController.navigate("${NavigationItem.DetailNews.route}/${pk[index]}")
                        },
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 520.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .height(20.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(images.size) {
                            val color = if (pagerState.currentPage == it) Color.DarkGray else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}