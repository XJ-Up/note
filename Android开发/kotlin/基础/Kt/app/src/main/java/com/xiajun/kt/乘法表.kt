package com.xiajun.kt
/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {

    var line = 9

    for(i in 1..line) {
        for(j in 0 until i) {
            print("${j + 1} x $i = ${(j + 1) * i}\t\t")
        }
        println()
    }

    println("乘法表")
}