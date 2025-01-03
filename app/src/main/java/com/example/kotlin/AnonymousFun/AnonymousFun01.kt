package com.example.kotlin.AnonymousFun

fun main() {
    val total = "ymy".count()
    "ymy".count({letter ->
        letter == 'y'
    })

}