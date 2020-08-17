package com.xiajun.kt

import java.util.*

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
fun main(args: Array<String>) {
    var list1 = arrayListOf<String>()
    list1.add("a")
    list1.add("b")
    list1.add("c")
    if ("d" in list1) {
        println(true)
    }
    for (value in list1) {
        print("$value\t")
    }
    println()

    var array1 = arrayOf("1", 2, "3")
    var list2 = arrayListOf(*array1)
    if ("d" in list2) {
        println(true)
    }

    for (value in list2) {
        print("$value\t")
    }
    println()

    var list3: ArrayList<String> = ArrayList()
    list3.add("e")
    list3.add("f")
    list3.add("g")
    for (value in list3) {
        print("$value\t")
    }
    println()

    var list4: LinkedList<String> = LinkedList()
    list4.add("h")
    list4.add("i")
    list4.add("j")
    for (value in list4) {
        print("$value\t")
    }
    println()

    var list5 = mutableListOf<String>()
    list5.add("k")
    list5.add("l")
    list5.add("m")
    for (value in list5) {
        print("$value\t")
    }
    println()

    var map1 = mapOf<String, Any>("1001" to "小明", "1002" to "小华", "1003" to 123)
    for ((key, value) in map1) {
        println("key=$key\tvalue=$value")
    }
    map1.forEach {
        println("key=${it.key}\tvalue=${it.value}")
    }
    println()

    var map2 = mutableMapOf<String, Any>("2001" to "小猫", "2002" to "小狗")
    for ((key, value) in map2) {
        println("key=$key\tvalue=$value")
    }
    println()
    map2["2003"] = "小猪"
    map2.forEach {
        println("key=${it.key}\tvalue=${it.value}")
    }
    println()

    for(value in 1..100 step 5) {
        print("$value\t")
    }
    println()

    for(value in 0 until 10) {
        print("$value\t")
    }
    println()
}