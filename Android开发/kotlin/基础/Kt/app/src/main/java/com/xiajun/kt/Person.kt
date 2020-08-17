package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
class Person(var name: String, var age: Int) {
    fun printInfo() {
        println("name is $name \t age is $age")
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}