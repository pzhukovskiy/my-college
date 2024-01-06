package com.example.project.compose.screens

import androidx.compose.foundation.background
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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.data.administration.AdministrationInfo
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun AdministrationScreen(
    navController: NavHostController,
    administrationList: List<AdministrationInfo>,
    onBackClick: () -> Unit
) {

    Scaffold(
        content = { paddingValues ->
            Column {
                StaticHeaderWidget(
                    text = stringResource(id = R.string.administration),
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )

                LazyColumn(content = {
                    items(administrationList) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(140.dp)
                                ) {
                                    AsyncImage(
                                        model = it.fields.image,
                                        contentDescription = it.pk.toString(),
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(140.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "${it.fields.middle_name} ${it.fields.first_name} ${it.fields.last_name}",
                                            style = MaterialTheme.typography.body1,
                                            color = Color.Black,
                                            fontFamily = Roboto,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight(500),
                                            modifier = Modifier.padding(start = 4.dp)
                                        )
                                        Text(
                                            text = "${stringResource(id = R.string.administration_position)} ${it.fields.position}",
                                            style = MaterialTheme.typography.body2,
                                            color = Color.Black,
                                            fontFamily = Roboto,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight(400),
                                            modifier = Modifier.padding(start = 4.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(horizontal = 12.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Box(modifier = Modifier
                                                .background(Color(PrimaryBlue.toArgb()))
                                                .height(40.dp)
                                                .fillMaxWidth(),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = stringResource(id = R.string.administration_detail_info),
                                                    style = MaterialTheme.typography.body1,
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
    )
}