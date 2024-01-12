package com.example.project.compose.widgets.about_college

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project.R
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun AboutCollegeWidget(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.college),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column() {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(400.dp)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.college_short_name),
                        fontFamily = Roboto,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(700),
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .width(400.dp)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .height(40.dp)
                        .fillMaxWidth()
                        .background(Color(PrimaryBlue.toArgb()))
                        .clickable {
                            navController.navigate(NavigationItem.AboutCollege.route)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.link_about_college),
                        fontFamily = Roboto,
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(500),
                    )
                }
            }
        }
    }
}