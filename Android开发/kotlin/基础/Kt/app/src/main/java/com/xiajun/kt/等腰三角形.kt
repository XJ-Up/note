package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {

    var line = 10
    for(i in 1..line) {
        // 打印空格
        for(j in line - i - 1 downTo 0) {
            print(" ")
        }

        for(k in 0 until 2 * i - 1) {
            print("*")
        }

        println()
    }

    println("等腰三角形")
}