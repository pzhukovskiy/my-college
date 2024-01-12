package com.example.project.compose.widgets.logic

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.R
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import java.text.SimpleDateFormat

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun EmailButtonWidget(
    context: Context
) {

    val currentTime = SimpleDateFormat("HH:mm")

    Box(
        modifier = Modifier
            .height(25.dp)
            .width(165.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")

                    putExtra(Intent.EXTRA_TEXT, context.getString(R.string.mail_text))
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(context.getString(R.string.mail_address)))
                    putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.mail_subject))
                }

                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, context.getString(R.string.error_open_app), Toast.LENGTH_LONG).show()
                }
            },
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Default.MailOutline,
                contentDescription = "mail",
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = Color(PrimaryBlue.toArgb())
            )
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSize / 4))
            Text(
                text = context.getString(R.string.write_mail),
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(400),
                color = Color(PrimaryBlue.toArgb())
            )
        }
    }
}