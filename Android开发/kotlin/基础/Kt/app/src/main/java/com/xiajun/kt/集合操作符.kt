package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {

    var list1 : ArrayList<String> = arrayListOf("a", "b", "c")
    println("first()->${list1.first()}")
    println("last()->${list1.last()}")
    println("contains()->${list1.contains("b")}")
    println("indexOf()->${list1.indexOf("c")}")
    println("elementAt()->${list1.elementAt(1)}")
    println("elementAtOrElse()->${list1.elementAtOrElse(10){"x"}} ")
}