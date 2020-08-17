package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/19
 * Description：泛型
 */
//Kotlin中允许定义全局函数，将函数定义在kt文件中，然后全局可调用
fun <T> appendString(tag:String, vararg otherInfo: T?):String {
    var str:String = "$tag:"
    for (item in otherInfo) {
//遍历可变数组，然后拼接
        str = "$str${item.toString()},"
    }
    return str
}
fun <T> Test1(test:T){
    println(test is Int)
}
fun main() {
    var appendString = appendString<String>("中国四大发明", "造纸术", "火药", "印刷术", "指南针")
    println(appendString)
    Test1("dasdas")
    Test1(12)
}