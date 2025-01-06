package com.example.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var startServiceButton: Button
    private lateinit var stopServiceButton: Button
    lateinit var downloadBinder: MyService.DownloadBinder
    private lateinit var binderServiceButton: Button
    private lateinit var unbindServiceButton: Button

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startServiceButton = findViewById(R.id.startServiceBtn)
        startServiceButton.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }
        stopServiceButton = findViewById(R.id.stopServiceBtn)
        stopServiceButton.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
        binderServiceButton = findViewById(R.id.bindServiceBtn)
        binderServiceButton.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE) //绑定Service
        }
        unbindServiceButton = findViewById(R.id.unbindServiceBtn)
        unbindServiceButton.setOnClickListener {
            unbindService(connection) //解绑
        }
    }
}