package com.example.kotlin.AnonymousFun

//StringBuilder.()
//在函数类型的前面加上ClassName. 就表示这个函数类型是定义在哪个类当中的。
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun main() {
    val list = listOf("Apple", "Orange")
    val result = StringBuilder().build {
        append("Start eating.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all")
    }
    println(result.toString())

}