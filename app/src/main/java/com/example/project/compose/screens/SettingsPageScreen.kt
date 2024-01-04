package com.example.project.compose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsPageScreen() {
    Scaffold(
        content = {
            Column {
                Text(text = "text", modifier = Modifier.padding(top = 20.dp))
            }
        }
    )
}