package com.example.networktest

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var plusButton: Button
    private lateinit var infoText: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        //通过ViewModelProvider来获取ViewModel的实例
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        plusButton = findViewById(R.id.plusOneBtn)
        plusButton.setOnClickListener {
            viewModel.plusOne()
        }
        clearButton = findViewById(R.id.clearBtn)
        clearButton.setOnClickListener {
            viewModel.clear()
        }
        //counter变量已经变成了一个LiveData对象，任何LiveData对象都可以调用它的observe()方法来观察数据的变化。
        //observe()方法接收两个参数：第一个参数是一个LifecycleOwner对象
        //第二个参数是一个Observer接口，当counter中包含的数据发生变化时，就会回调到这里
        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
    }

    private fun refreshCounter() {
        infoText = findViewById(R.id.infoText)
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()

    }
}