package com.example.project.compose.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.auth.UserData
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.Roboto

@Composable
fun BottomBarCustomWidget(
    navController: NavController,
    userData: UserData?
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        contentAlignment = Alignment.Center,
    ) {

//        Image(
//            painter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box(
                modifier = Modifier.weight(1f).height(60.dp).clickable { navController.navigate(NavigationItem.ListAllLinks.route) },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = Icons.Default.List, contentDescription = null, tint = Color.Black)
                    Text(
                        text = stringResource(id = R.string.links),
                        fontFamily = Roboto,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(400),
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                }
            }
//            Box(
//                modifier = Modifier.weight(1f).height(60.dp).clickable { navController.navigate(NavigationItem.SettingsPage.route) },
//                contentAlignment = Alignment.Center
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Icon(imageVector = Icons.Default.Settings, contentDescription = null, tint = Color.Black)
//                    Text(
//                        text = stringResource(id = R.string.settings),
//                        fontFamily = Roboto,
//                        fontStyle = FontStyle.Normal,
//                        fontWeight = FontWeight(400),
//                        style = MaterialTheme.typography.body1,
//                        color = Color.Black,
//                        fontSize = 10.sp
//                    )
//                }
//            }
            Box(
                modifier = Modifier.weight(1f).height(60.dp).clickable { navController.navigate(NavigationItem.Profile.route) },
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
                                .size(25.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.profile),
                        fontFamily = Roboto,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(400),
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}