package com.example.kotlin.AnonymousFun

fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

fun main() {
    val items = listOf(1, 2, 3, 4)

    //Lambdas表达式是花括号括起来的代码块
    items.fold(0, {
        //前面是参数，后跟->
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        //lambda最后一个表达式是返回值
        result
    })
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
}