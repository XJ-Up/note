package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/6.
 * chenshichao@outlook.com
 */
class Static {

    object Obj {
        fun test() {
            println("测试静态伴生")
        }
    }
}

fun main(args: Array<String>) {
    Static.Obj.test()
}