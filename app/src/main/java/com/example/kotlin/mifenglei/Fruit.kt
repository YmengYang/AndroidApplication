package com.example.kotlin.mifenglei

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()
class UnKnow(val msg: String) : Result()

fun getResultMsg(result: Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
    is UnKnow -> result.msg
}

fun main() {
    val success: Success = Success("sssss")
    println(getResultMsg(success))

    val unKnown: UnKnow = UnKnow("未知错")
    println(getResultMsg(unKnown))
}