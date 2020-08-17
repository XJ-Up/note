package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/19
 * Description：尾递归函数
 */
//求余弦不动点
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))
fun main() {
    var findFixPoint = findFixPoint(2.3)
    println(findFixPoint)
}