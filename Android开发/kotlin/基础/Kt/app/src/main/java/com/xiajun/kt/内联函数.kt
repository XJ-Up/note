package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/19
 * Description：内联函数
 */
fun Chuandi(string: String):Unit{
}
//此函数为 高阶函数 加 inline内联
inline fun Neilian( int: Int,chuandi:()->String){
    println("我内联函数")
     var chuandi1 = chuandi()
     println(chuandi1)
 }
fun main() {
        Neilian (1){
            Chuandi("dasdasda")
            "aaaa"
        }
}