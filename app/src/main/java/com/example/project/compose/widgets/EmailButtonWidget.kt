package com.example.project.compose.widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EmailButtonWidget(
    context: Context
) {
    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("mgke@minskedu.gov.by"))
                putExtra(Intent.EXTRA_SUBJECT, "Тема письма")
                putExtra(Intent.EXTRA_TEXT, "Добрый день, это текст сообщения, измените его")
            }

            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Невозможно открыть приложение", Toast.LENGTH_LONG).show()
            }
        }
    ) {
        Text("Написать на почту")
    }
}