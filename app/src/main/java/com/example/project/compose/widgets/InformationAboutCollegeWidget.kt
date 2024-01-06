package com.example.project.compose.widgets

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.project.R
import com.example.project.ui.theme.Roboto
import java.util.Calendar

@Composable
fun InformationAboutCollegeWidget(
    context: Context
) {

    val year = Calendar.getInstance().get(Calendar.YEAR)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Column {
            Text(
                text = "${context.getString(R.string.college_name)} $year",
                fontFamily = Roboto,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(700),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = context.getString(R.string.college_address),
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