package com.example.project.services

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.example.project.R
import kotlin.random.Random

class NotificationService(
    private val context: Context
){
    private val notificationManager=context.getSystemService(NotificationManager::class.java)
    fun showBasicNotification(){
        val notification= NotificationCompat.Builder(context,"project_notification")
            .setContentTitle(context.getString(R.string.schedule))
            .setContentText(context.getString(R.string.schedule_new))
            .setSmallIcon(R.drawable.logo)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showExpandableNotification(){
        val notification= NotificationCompat.Builder(context,"project_notification")
            .setContentTitle(context.getString(R.string.schedule))
            .setContentText(context.getString(R.string.schedule_new))
            .setSmallIcon(R.drawable.logo)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(
                        context.bitmapFromResource(
                            R.drawable.dark_gray_background_with_polygonal_forms_vector
                        )
                    )
            )
            .build()
        notificationManager.notify(Random.nextInt(),notification)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId:Int
    )= BitmapFactory.decodeResource(
        resources,
        resId
    )
}