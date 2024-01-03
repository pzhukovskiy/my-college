package com.example.project.compose.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.ui.theme.Roboto
import java.util.Calendar

@Composable
fun InformationAboutCollegeWidget() {

    val year = Calendar.getInstance().get(Calendar.YEAR)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Column {
            Text(
                text = "© УО Минский государственный колледж цифровых технологий, $year",
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(700),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = "Адрес: 220108, Республика Беларусь, г. Минск, ул. Казинца, 91",
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.body2
            )

            EmailButtonWidget(context = LocalContext.current)

            TelephoneButtonWidget(context = LocalContext.current)
        }
    }
}