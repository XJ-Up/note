package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/20
 * Description：高阶函数
 */
fun  Gaojie(int: Int):Int{
    return int
}
fun  Ceshi(gaojie:()->Int){
    println(gaojie())
}
fun main() {
    Ceshi {
        Gaojie(5)
    }
}