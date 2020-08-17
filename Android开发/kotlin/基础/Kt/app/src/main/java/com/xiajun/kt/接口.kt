package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/17.
 * chenshichao@outlook.com
 */
interface Intef1 {
    fun method1(): String
    fun method2()
}

interface Intef2 {
    fun method3()
    fun method4(): Int {
        return 1
    }
}

class IntefTest : Intef1, Intef2 {

    override fun method4(): Int {
        return super.method4()
    }

    override fun method3() {
        println("method3")
    }

    override fun method2() {
        println("method2")
    }

    override fun method1(): String {
        return "test"
    }
}

fun main(args: Array<String>) {
    var intefTest = IntefTest()
    println(intefTest.method1())
    intefTest.method2()
    intefTest.method3()
    println(intefTest.method4())
}