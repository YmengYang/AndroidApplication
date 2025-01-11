package com.example.networktest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var sendRequestButton: Button
    private lateinit var responseText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendRequestButton = findViewById(R.id.sendRequestBtn)
        sendRequestButton.setOnClickListener {
            sendRequestWithOkHttp()
        }
    }

    private fun sendRequestWithOkHttp() {
        Log.d("MainActivity", "sendRequestWithOkHttp1: ")
        Thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder().url("https://www.baidu.com").build()
                val response = client.newCall(request).execute()
                val responseData = response.body?.string()
                if (responseData != null) {
                    showResponse(responseData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            // 在这里进行UI操作，将结果显示到界面上
            responseText = findViewById(R.id.responseText)
            responseText.text = response
        }
    }
}