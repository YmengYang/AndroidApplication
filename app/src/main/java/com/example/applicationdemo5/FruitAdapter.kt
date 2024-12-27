package com.example.applicationdemo5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(val fruitList: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    //获取布局
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    //用于创建ViewHolder实例的，我们在这个方法中将
    //fruit_item布局加载进来，然后创建一个ViewHolder实例，并把加载出来的布局传入构造函数当中，最后将ViewHolder的实例返回。
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        //添加点击事件
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked view ${fruit.name}",
                Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked image ${fruit.name}",
                Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun getItemCount() = fruitList.size

    //对RecyclerView子项的数据进行赋值
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }
}