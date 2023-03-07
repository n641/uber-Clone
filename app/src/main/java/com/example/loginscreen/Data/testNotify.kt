package com.example.loginscreen.Data

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import com.example.loginscreen.MainActivity
import com.example.loginscreen.R
import com.example.loginscreen.Notification_Manager

class testNotify : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager

    lateinit var button :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        val Notf= Notification_Manager()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_notify)


        button =findViewById(R.id.button)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val contentView = RemoteViews(packageName, R.layout.activity_main)

            Notf.Notify(notificationManager , contentView ,pendingIntent, this );

        }
    }
}