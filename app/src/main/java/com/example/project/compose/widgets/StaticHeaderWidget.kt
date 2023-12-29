package com.example.project.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.ui.theme.Roboto

@Composable
fun StaticHeaderWidget(
    text: String,
    imagePainter: Painter,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            IconButton(onClick = { onBackClick() }, modifier = Modifier.padding(top = 20.dp)) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 20.dp, start = 10.dp)
            )
        }
    }
}
