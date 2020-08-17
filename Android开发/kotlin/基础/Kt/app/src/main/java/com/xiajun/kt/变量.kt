package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {
    var count = 2
    val price: Float = 18.35f
    val name: String = "大米"

    println("名称：$name")
    println("单价：$price")
    println("数量：$count")
    println("总价：${ price * count }")
}