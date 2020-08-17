package com.xiajun.kt

/**
 * Created by ChenS on 2019/6/5.
 * chenshichao@outlook.com
 */
open class Pet(var name: String, var age: Int) {
    override fun toString(): String {
        return "name = $name\t age = $age"
    }
}

class Cat(name : String, age : Int, color : String) : Pet(name, age)

fun main(ages: Array<String>) {

    var petList : List<Pet>
    var catList : List<Cat> = mutableListOf(Cat("小橘", 5, "橘黄色"), Cat("中分", 3, "黑白"))
    petList = catList// 协变
    petList.forEach {
        println(it.toString())
    }

    println()

    var list1 : MutableList<Pet>
    var list2 : List<Cat> = listOf(Cat("小橘", 5, "橘黄色"), Cat("中分", 3, "黑白"))
    list1 = list2.toMutableList()
    list1.add(Pet("胖胖", 19))
    list1.add(Pet("瘦瘦", 21))
    for(pet in list1) {
        println(pet.toString())
    }
}