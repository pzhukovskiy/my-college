package com.example.project.compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.compose.widgets.StaticHeaderWidget
import com.example.project.ui.theme.Roboto
import com.example.project.utilities.listAllLinks

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListAllLinksScreen(
    onBackClick: () -> Unit
) {

    Scaffold(
        content = {
            Column {
                StaticHeaderWidget(
                    text = stringResource(id = R.string.links),
                    imagePainter = painterResource(id = R.drawable.dark_gray_background_with_polygonal_forms_vector),
                    onBackClick = {
                        onBackClick()
                    }
                )

                LazyColumn(content = {
                    items(listAllLinks) { link ->
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .background(Color.LightGray),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Box(
                                contentAlignment = Alignment.CenterEnd,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        Icons.Default.ArrowForward,
                                        contentDescription = "Forward",
                                        tint = Color.White
                                    )
                                }
                                Text(
                                    text = link.text,
                                    style = MaterialTheme.typography.h6,
                                    color = Color.White,
                                    fontFamily = Roboto,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight(500),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                })
            }
        }
    )

}