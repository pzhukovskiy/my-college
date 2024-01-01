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
import com.example.project.ui.theme.PrimaryBlue
import com.example.project.ui.theme.Roboto
import com.example.project.utilities.EmailText
import java.text.SimpleDateFormat
import java.util.Date

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

                    if (currentTime.format(Date()) >= "00:00" && currentTime.format(Date()) <= "01:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextNight.text)
                    }
                    else if (currentTime.format(Date()) >= "01:00" && currentTime.format(Date()) <= "02:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextNight.text)
                    }
                    else if (currentTime.format(Date()) >= "02:00" && currentTime.format(Date()) <= "03:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextNight.text)
                    }
                    else if (currentTime.format(Date()) >= "03:00" && currentTime.format(Date()) <= "04:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextNight.text)
                    }
                    else if (currentTime.format(Date()) >= "04:00" && currentTime.format(Date()) <= "05:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "05:00" && currentTime.format(Date()) <= "06:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "06:00" && currentTime.format(Date()) <= "07:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "07:00" && currentTime.format(Date()) <= "08:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "08:00" && currentTime.format(Date()) <= "09:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "09:00" && currentTime.format(Date()) <= "10:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "10:00" && currentTime.format(Date()) <= "11:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "11:00" && currentTime.format(Date()) <= "12:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextMorning.text)
                    }
                    else if (currentTime.format(Date()) >= "12:00" && currentTime.format(Date()) <= "13:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextDay.text)
                    }
                    else if (currentTime.format(Date()) >= "13:00" && currentTime.format(Date()) <= "14:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextDay.text)
                    }
                    else if (currentTime.format(Date()) >= "14:00" && currentTime.format(Date()) <= "15:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextDay.text)
                    }
                    else if (currentTime.format(Date()) >= "15:00" && currentTime.format(Date()) <= "16:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextDay.text)
                    }
                    else if (currentTime.format(Date()) >= "16:00" && currentTime.format(Date()) <= "17:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextDay.text)
                    }
                    else if (currentTime.format(Date()) >= "17:00" && currentTime.format(Date()) <= "18:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "18:00" && currentTime.format(Date()) <= "19:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "19:00" && currentTime.format(Date()) <= "20:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "20:00" && currentTime.format(Date()) <= "21:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "21:00" && currentTime.format(Date()) <= "22:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "22:00" && currentTime.format(Date()) <= "23:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    else if (currentTime.format(Date()) >= "23:00" && currentTime.format(Date()) <= "00:00") {
                        putExtra(Intent.EXTRA_TEXT, EmailText.MailTextEvening.text)
                    }
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(EmailText.MailAddress.text))
                    putExtra(Intent.EXTRA_SUBJECT, EmailText.MailSubject.text)
                }

                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Невозможно открыть приложение", Toast.LENGTH_LONG).show()
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
                text = "Написать на почту",
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(400),
                color = Color(PrimaryBlue.toArgb())
            )
        }
    }
}