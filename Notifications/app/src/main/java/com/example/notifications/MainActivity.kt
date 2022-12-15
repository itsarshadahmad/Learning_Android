package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    // Notification is generate by another application build inside android system
    // which generate notification when notification manager tell it. Notification
    // is generate by different application that's why it doesn't have access to point
    // to any activity by itself, it requires pending intent to does that job and it
    // has to be configured by developer to show any activity or fragment.

    // A PendingIntent is a reference to a token maintained by the system. Application A
    // can pass a PendingIntent to application B in order to allow application B to
    // execute predefined actions on behalf of application A; regardless of whether
    // application A is still alive.

    // Notification channel will act as host to hold notifications and its behaviours
    // Channel name and ID is required to differentiate notification
    private val CHANNEL_NAME = "Channel_Name"
    private val CHANNEL_ID = "Channel_ID"
    private val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNotification = findViewById<Button>(R.id.btnNotification)

        // Prepare notification channel at app runtime
        createNotificationChannel()

        // Building feature to get back to app from outside of app
        val intent = Intent(this, MainActivity::class.java)
        // This will allow us to get to activity
        val pendingIntent = TaskStackBuilder.create(this).run {
            // This will add your activity on activity stack and will allow to go back
            // other app or previous activity.
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        // Notification configuration and behavior, text, icons, etc
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.ic_star)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) // this will set pending intent
            .build() // return notification

        // Notification manager to manage notifications
        val notificationManager = NotificationManagerCompat.from(this)

        btnNotification.setOnClickListener {
            // This will show our notification
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    // Before android oreo its not require to create notification channel but from oreo its required to create
    fun createNotificationChannel() {
        // checking weather android version is oreo and letter
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN // Notification light
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}