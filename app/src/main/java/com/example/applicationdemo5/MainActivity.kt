package com.example.applicationdemo5

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化列表内的数据
        initFruits()
        //指定recyclerView的布局方式
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL //设置布局的排列方式
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Apple", R.drawable.apple))
            fruitList.add(Fruit("Apple", R.drawable.apple))
        }
    }
}