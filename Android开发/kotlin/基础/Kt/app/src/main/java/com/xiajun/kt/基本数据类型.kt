package com.xiajun.kt

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/18
 * Description：基本数据类型
 */
fun main() {
    /**
     * 基本类型
     */

    var  a:Int=2
    var  b:Long=2L
    var  c:Float=2F
    var  d:Double=2.5
    var  e:Boolean=true
    var  f:Char = 55.toChar()
    //类型之间转换 都是 to+类型 例如:
    var toString = a.toString()
    /**
     * 数组
     */
    /*基本类型数组声明*/
    //除（String）都是以基本类型 +ArrayOf声明
    intArrayOf()
    //String为 arrayOf
    /*注意：其他 类型也可以通过  arrayOf声明*/
    var arrayOf = arrayOf("夏", "军")
    /*数组与元素操作*/
    //长度  通过 size获取
    var size = arrayOf.size
    /*获取或修改*/
    //获取
    var s = arrayOf[0]
    var get = arrayOf.get(0)
    //设置
    arrayOf[0]="6"
    arrayOf.set(0,"6")

}