package com.example.project.compose.widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TelephoneButtonWidget(
    context: Context
) {
    Button(
        onClick = {
            val phoneNumber = "+375173741162"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }

            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Невозможно открыть приложение", Toast.LENGTH_LONG).show()
            }
        }
    ) {
        Text("Позвонить")
    }
}