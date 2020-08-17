package com.xiajun.kt

import java.io.File

/**
 * QQ：1326227115
 * @author xj
 * CreationTime：2020/5/20
 * Description：几个有用的函数
 */
fun main() {
    var person = Person("夏军",20)
    /*、let函数适用的场景

场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。

场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用*/
    person.let {
        println(it)
    }
    /*
    * run函数的适用场景

适用于let,with函数任何场景。
* 因为run函数是let,with两个函数结合体，
* 准确来说它弥补了let函数在函数体内必须使用it参数替代对象，
* 在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，
* 另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
*/
    person.run {
        println(this)
    }
    /*also函数的适用场景

适用于let函数的任何场景，also函数和let很像，
只是唯一的不同点就是let函数最后的返回值是最后一行的返回值而also函数的返回值是返回当前的这个对象。
一般可用于多个扩展函数链式调用

    * */
    person.also {
        println(it)
    }
    /*
    * apply函数的适用场景

整体作用功能和run函数很像，
* 唯一不同点就是它返回的值是对象本身，
* 而run函数是一个闭包形式返回，返回的是最后一行的值。
* 正是基于这一点差异它的适用场景稍微与run函数有点不一样。
* apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。
* 或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，这种情景非常常见。
* 特别是在我们开发中会有一些数据model向View model转化实例化的过程中需要用到。
    */
    person.apply {
        println(this)
    }
    File("build.gradle").inputStream().reader().buffered()
        .use {
            println(it.readLines())
        }
}