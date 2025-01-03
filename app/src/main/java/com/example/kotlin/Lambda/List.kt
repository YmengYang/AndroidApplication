package com.example.kotlin.Lambda

fun main() {
    val list = mutableListOf("a", "b")
    for (char in list) {
        println(char)
    }

//    val map = HashMap<String, Int>()
//    map.put("apple", 1)
//    map["origin"] = 2
//    println(map.get("apple"))

    val map = mapOf("a" to 1, "b" to 2)
    for ((x, y) in map) {
        println(x + "char" + ", value" + y)
    }


}