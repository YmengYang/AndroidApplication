package com.example.applicationdemo5

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlin.math.log

class FragmentActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fragment)
    }

    //动态加载fragment
    fun loadRightFragment() {
        Log.d("FragmentActivity", "loadRightFragment")
        val fragmentRight = Fragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.rightLayout, fragmentRight)
            .commit()
    }
}