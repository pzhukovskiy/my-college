package com.example.project.compose.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.project.ui.theme.Roboto
import com.example.project.utilities.calculateWidthForButton

//calculates the length of the button depending on the length of the word
@Composable
fun RoundedButtonWithTextWidget(text: String, height: Dp, color: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .height(height)
            .width(calculateWidthForButton(text.length))
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 2.dp,
                Color(color = color.toArgb()),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = text,
            color = Color(color = color.toArgb()),
            style = MaterialTheme.typography.subtitle2,
            fontFamily = Roboto,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(500)
        )
    }
}