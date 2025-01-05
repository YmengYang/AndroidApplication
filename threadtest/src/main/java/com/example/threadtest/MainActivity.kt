package com.example.threadtest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.concurrent.thread

//当子线程中需要进行UI操作时，就创建一个Message对象，并
//通过Handler将这条消息发送出去。之后这条消息会被添加到MessageQueue的队列中等待被
//处理，而Looper则会一直尝试从MessageQueue中取出待处理消息，最后分发回Handler的
//handleMessage()方法中。由于Handler的构造函数中我们传入了
//Looper.getMainLooper()，所以此时handleMessage()方法中的代码也会在主线程中运行，
//于是我们在这里就可以安心地进行UI操作了。
class MainActivity : AppCompatActivity() {

    val updateText = 1
    private lateinit var textView: TextView
    private lateinit var changeButton: Button

    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            textView = findViewById(R.id.textView)
            when (msg.what) {
                updateText -> textView.text = "hello"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeButton = findViewById(R.id.changeTextBtn)
        changeButton.setOnClickListener {
            Thread {
                val msg = Message()
                msg.what = updateText
                handler.sendMessage(msg)
            }.start()
        }
    }
}