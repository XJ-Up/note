package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/18
 * Description：When操作符
 */
/*基本操作*/
fun testWhen(value: Int) {
    when(value) {
        0-> {
            println("is Int.1")
        }
        1 -> {
            println("is Int.2")
        }
        else -> {
            println("is something i don't care.")
        }
    }
}
/*一表达式为分支条件*/
//is=instance
fun testWhen1(obj: Any) {
    when(obj) {
        is Int -> {
            println("is Int.")
        }
        is String -> {
            println("is String. length=${obj.length}")
        }
        else -> {
            println("is something i don't care.")
        }
    }
}
/*穿透操作*/
fun testWhen2(value: Int) {
    when(value) {
        in 10 .. Int.MAX_VALUE -> {
            println("$value 太大了，我懒得算")
        }
        2, 3, 5, 7 -> {
            println("$value 是质数")
        }
        else -> {
            println("$value 不是质数")
        }
    }
}

fun main(args: Array<String>) {
    testWhen(0)
    testWhen(5)
    testWhen1(1)
    testWhen1("1111")
    testWhen1(1.0f)
    println()

    (0 .. 10).forEach {
        testWhen2(it)
    }

    println()
}