package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
//fun main(args: Array<String>) {
//
//    var x = 4
//    var y = 10
//
//    // 判断x是否在1-y的区间内，如果是，打印true
//    if(x in 1..y) {
//        println(true)
//    }
//
//    // 判断x是否不在1-y的区间内，如果不在，打印false
//    if(x !in 1..y) {
//        println(false)
//    }
//
//    // 循环打印
//    for(z in 1..5) {
//        println("$z\t")
//    }
//}

fun main() {
    val x =7

    val y=5
    // 判断x是否在1-y的区间内，如果是，打印true
    if (x in 1 ..y)
    {
        println(true)
    }else{

        println(false)
    }
    // 判断x是否不在1-y的区间内，如果不在，打印false
    if (x !in 1..y){
        println(true)
    }else{
        println(false)
    }
    // 循环打印
    for (z in 1..y){
        println("$z\t")
    }


}
class  T() : Test (1) {

}
open class  Test (var x:Int ){
    val y =7

}




open class  In (){

}