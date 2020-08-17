package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/17.
 * chenshichao@outlook.com
 */
enum class EnumTest(var color: String) {
    BLACK("黑色"),
    WHITE("白色");
}

fun main(args: Array<String>) {
    println(EnumTest.BLACK.color)
}