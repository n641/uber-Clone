package com.example.loginscreen

import android.app.*
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.RemoteViews
import androidx.core.content.ContextCompat.getSystemService

class Notification_Manager {
//    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel

    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

     fun Notify(notificationManager : NotificationManager , contentView: RemoteViews ,pendingIntent: PendingIntent , context: Context ){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(context, channelId)
                .setContent(contentView)
                .setSmallIcon(R.drawable.ic_baseline_access_time_24)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_baseline_add_location_24))
                .setContentIntent(pendingIntent)


        } else {

            builder = Notification.Builder(context)
                .setContent(contentView)
                .setSmallIcon(R.drawable.ic_baseline_access_time_24)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_baseline_add_location_24))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234, builder.build())
    }
}