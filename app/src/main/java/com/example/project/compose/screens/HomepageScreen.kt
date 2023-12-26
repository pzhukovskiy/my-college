package com.example.project.compose.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.AnimatedHeaderWidget

//scrollState.maxValue == 1423

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen() {

    val scrollState = rememberScrollState()
    val images = listOf(
        R.drawable.king_kohli,
        R.drawable.football,
        R.drawable.football2,
    )

    Box {

        val pagerState = rememberPagerState()


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
                    pageCount = images.size,
                    state = pagerState,
                    key = {images[it]},
                    pageSize = PageSize.Fill
                ) { index ->
                    Image(
                        painter = painterResource(id = images[index]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .padding(top = 350.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .height(40.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 120.dp)
                                .background(Color.White)
                        ) {
                            Row(
                                modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                repeat(images.size) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .height(30.dp)
                                            .width(30.dp)
                                            .background(if (it == index) Color.Black else Color.LightGray)
                                    ) {
                                        Text(text = it.toString(), color = (if (it == index) Color.White else Color.Black))
                                    }
                                }
                            }
                        }

                        //последний box с текстом
                        if (index == images.size - 1) {
                            Text(
                                text = stringResource(id = R.string.check_all_news),
                                color = Color.White,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth()
                                    .wrapContentSize(align = Alignment.Center)
                            )
                        }
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