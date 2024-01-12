package com.example.project.compose.widgets.headers

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.ui.theme.Roboto
import java.lang.Float

@Composable
fun AnimatedHeaderWidget(
    text: String,
    imagePainter: Painter,
    scrollState: ScrollState
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .graphicsLayer {
                alpha = Float.min(1f, (scrollState.value.toFloat() / (scrollState.maxValue / 3)))
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            color = Color.White,
            fontFamily = Roboto,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight(500),
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}