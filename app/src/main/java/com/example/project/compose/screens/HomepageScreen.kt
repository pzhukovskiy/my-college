package com.example.project.compose.screens

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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.widgets.AnimatedHeaderWidget
import com.example.project.data.news.NewsInfo
import com.example.project.navigation.NavigationItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(
    navController: NavHostController,
    newsList: List<NewsInfo>
) {

    val scrollState = rememberScrollState()

    Box {

        val pagerState = rememberPagerState()

        val images = newsList.map { it.fields.image }
        val pk = newsList.map { it.pk }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp),
                contentAlignment = Alignment.Center,
            ) {
                HorizontalPager(
                    pageCount = newsList.size,
                    state = pagerState,
                    key = { pk[it]},
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
                        contentScale = ContentScale.Crop)
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

                        //last box with text
//                        if (index == images.size - 1) {
//                            Text(
//                                text = stringResource(id = R.string.check_all_news),
//                                color = Color.White,
//                                modifier = Modifier
//                                    .padding(top = 10.dp)
//                                    .fillMaxWidth()
//                                    .wrapContentSize(align = Alignment.Center)
//                            )
//                        }
                    }
                }
            }

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(12.dp),
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = "fjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasjfjsalfjaslfjaslfasj",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }

        AnimatedHeaderWidget(
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            text = stringResource(R.string.main_page),
            scrollState = scrollState
        )
    }
}