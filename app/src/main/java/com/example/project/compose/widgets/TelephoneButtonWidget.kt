package com.example.project.compose.widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto

@Composable
fun TelephoneButtonWidget(
    context: Context
) {

    Box(
        modifier = Modifier
            .height(25.dp)
            .width(105.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                val phoneNumber = "+375173741162"
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phoneNumber")
                }

                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast
                        .makeText(context, "Невозможно открыть приложение", Toast.LENGTH_LONG)
                        .show()
                }
            },
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.Call,
                contentDescription = "telephone",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color(PrimaryBlue.toArgb())
            )
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSize / 4))
            Text(
                text = stringResource(id = R.string.telephone),
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(400),
                color = Color(PrimaryBlue.toArgb())
            )
        }
    }
}