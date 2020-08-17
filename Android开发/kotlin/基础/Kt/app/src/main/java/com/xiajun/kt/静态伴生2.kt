package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/6.
 * chenshichao@outlook.com
 */
object Obj {

    var stat = 1

    fun testStatic() {
        println("测试静态伴生2")
    }
}

fun main(args: Array<String>) {

    Obj.testStatic()
    Obj.stat

    var javaObj = java调用kotlin静态伴生对象()
    javaObj.javaToKotlin()
}