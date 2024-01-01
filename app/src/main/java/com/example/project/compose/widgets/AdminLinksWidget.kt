package com.example.project.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project.R

@Composable
fun AdminLinksWidget() {

    val scrollState = rememberScrollState()

    val uriHandler = LocalUriHandler.current
    val presidentGovBy = "http://president.gov.by/"
    val educationGovBy = "http://edu.gov.by/"
    val ispolComitet = "https://minsk.gov.by/ru/"
    val educationComitet = "http://minsk.edu.by/"
    val administration = "https://okt.minsk.gov.by/"
    val ripo = "https://okt.minsk.gov.by/"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .horizontalScroll(scrollState),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(presidentGovBy)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.president_gov_by),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(educationGovBy)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edu_gov_by),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(ispolComitet)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ispol_comitet),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(educationComitet)
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.education),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(administration)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.administation),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(120.dp)
                    .padding(5.dp)
                    .clickable {
                        uriHandler.openUri(ripo)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ripo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}