package com.example.project.compose.widgets.headers

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.project.auth.UserData
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.Roboto

@Composable
fun HomepageHeaderWidget(
    text: String,
    imagePainter: Painter,
    navController: NavController,
    userData: UserData?,
) {
    Box(
        modifier = Modifier
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier = Modifier
                .height(80.dp)
        ) {

            Box(
                modifier = Modifier.weight(0.3f).height(80.dp).padding(top = 20.dp).clickable { navController.navigate(NavigationItem.ListAllLinks.route) },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = Icons.Default.List, contentDescription = null, tint = Color.White)
                }
            }

            Text(
                text = text,
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .padding(top = 17.5.dp)
                    .height(80.dp)
                    .weight(1f)
                    .wrapContentSize(Alignment.Center)
            )

            Box(
                modifier = Modifier.weight(0.3f).height(80.dp).padding(top = 20.dp).clickable { navController.navigate(
                    NavigationItem.Profile.route) },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (userData?.profilePictureUrl != null) {
                        AsyncImage(
                            model = userData.profilePictureUrl,
                            contentDescription = "профиль",
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}