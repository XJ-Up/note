package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/18
 * Description：循环遍历
 */
fun test(){
    /*遍历11倒20之间的数值 ，until声明了一个左闭右开的区间 */
    for (i in 11 until 20){
        println("执行次数$i")
    }
    /*遍历 23到 88 每次 +4*/
    for(i in 23..88 step 4){
        println("step执行$i")
    }
    /*倒叙遍历50到7*/
    for (i in 50 downTo 7){
        println("downTo执行$i")
    }

}
fun main() {
    test()
}