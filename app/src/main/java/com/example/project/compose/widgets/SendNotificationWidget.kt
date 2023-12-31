package com.example.project.compose.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.project.services.NotificationService
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SendNotificationWidget() {
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val waterNotificationService = NotificationService(LocalContext.current)
    LaunchedEffect(key1 = true ){
        if(!postNotificationPermission.status.isGranted){
            postNotificationPermission.launchPermissionRequest()
        }
    }
    Column {
        Button(
            onClick = {
                waterNotificationService.showBasicNotification()
            }
        ) {
            Text(text = "Базовое уведомление")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                waterNotificationService.showExpandableNotification()
            }
        ) {
            Text(text = "Уведомление с фото")
        }
    }
}