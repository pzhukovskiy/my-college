package com.example.project.compose.screens.about_college

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project.R
import com.example.project.compose.screens.about_college.button.ButtonWidget
import com.example.project.compose.widgets.headers.StaticHeaderWidget
import com.example.project.data.links.Links
import com.example.project.navigation.NavigationItem
import com.example.project.ui.theme.Roboto
import java.util.UUID

@Composable
fun AboutCollegeScreen(
    navController: NavController,
    onBackClick: () -> Unit
) {

    val uuid = UUID.randomUUID()

    val listAllLinks = listOf(
        Links(id = uuid.toString(), text = "1966 год",  route = NavigationItem.Info1966.route),
        Links(id = uuid.toString(), text = "1967 год",  route = NavigationItem.Info1967.route),
        Links(id = uuid.toString(), text = "1969 год",  route = NavigationItem.Info1969.route),
        Links(id = uuid.toString(), text = "1970 год",  route = NavigationItem.Info1970.route),
        Links(id = uuid.toString(), text = "1971 год",  route = NavigationItem.Info1971.route),
        Links(id = uuid.toString(), text = "1974 год",  route = NavigationItem.Info1974.route),
        Links(id = uuid.toString(), text = "1980 год",  route = NavigationItem.Info1980.route),
        Links(id = uuid.toString(), text = "1990 год",  route = NavigationItem.Info1990.route),
        Links(id = uuid.toString(), text = "2000 год",  route = NavigationItem.Info2000.route),
        Links(id = uuid.toString(), text = "2010 год",  route = NavigationItem.Info2010.route),
        Links(id = uuid.toString(), text = "2020 год",  route = NavigationItem.Info2020.route),
        Links(id = uuid.toString(), text = "2021 год",  route = NavigationItem.Info2021.route),
        Links(id = uuid.toString(), text = "2022 год",  route = NavigationItem.Info2022.route),
        Links(id = uuid.toString(), text = "2023 год",  route = NavigationItem.Info2023.route),
        Links(id = uuid.toString(), text = "2024 год",  route = NavigationItem.Info2024.route),
    )

    Column {
        StaticHeaderWidget(
            text = stringResource(id = R.string.link_about_college),
            imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
            onBackClick = {
                onBackClick()
            }
        )

        LazyColumn(content = {
            items(listAllLinks.reversed()) {
                Text(
                    text = it.text,
                    fontFamily = Roboto,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(500),
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                )
                ButtonWidget(navController = navController, route = it.route)
            }
            item {
                Spacer(modifier = Modifier.height(45.dp))
            }
        })
    }
}