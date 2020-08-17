package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/17.
 * chenshichao@outlook.com
 */
open class AClass {

    var name: String = "Freddy"
}

class BClass : AClass() {

    var name2: String = super.name

    fun print() {
        println(name2)
    }
}

fun main(args: Array<String>) {
    var bClass: BClass = BClass()
    bClass.print()
}