package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/6.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {

    var line = 9

    for(i in line downTo 1) {
        for(j in 1..i) {
            print("$j x $i = ${j * i}\t\t")
        }

        println()
    }

    println("倒乘法表")
}