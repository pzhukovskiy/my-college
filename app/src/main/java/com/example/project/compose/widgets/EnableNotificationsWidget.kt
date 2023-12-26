package com.example.project.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun EnableNotificationsWidget() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Cyan)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = stringResource(R.string.mgkct),
                        style = MaterialTheme.typography.subtitle2,
                        fontFamily = Roboto,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight(500),
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 5.dp)
                    )
                }
            }
            Box(modifier = Modifier.height(60.dp).fillMaxWidth().background(Color.Cyan)) {
                Text(
                    text = stringResource(R.string.connect_notifications),
                    style = MaterialTheme.typography.h6,
                    fontFamily = Roboto,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight(700)
                )
            }
            Box(modifier = Modifier.height(40.dp).fillMaxWidth().background(Color.Cyan)) {
                RoundedButtonWithTextWidget(
                    text = "Подключить",
                    color = Color(PrimaryBlue.toArgb()),
                    height = 30.dp
                ) {
                    /*TODO*/
                }
            }
        }
    }
}