package com.example.loginscreen

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews

class Details_page : AppCompatActivity() {
    lateinit var button : Button
    lateinit var notificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        val Notf= Notification_Manager()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)
        button=findViewById(R.id.buytic);
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        button.setOnClickListener {
            var intent1 = Intent(this , Details_page::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            val contentView = RemoteViews(packageName, R.layout.activity_main)

            Notf.Notify(notificationManager , contentView ,pendingIntent, this );
        }
    }
}