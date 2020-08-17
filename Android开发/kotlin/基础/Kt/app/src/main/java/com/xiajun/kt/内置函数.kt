package com.xiajun.kt


/**
 * Created by ChenS on 2019/12/11.
 * chenshichao@outlook.com
 */
fun main() {
    val person = Person("FreddyChen", 24)

    let(person)
    also(person)
    with(person)
    run(person)
    apply(person)
}

private fun let(person: Person?) {
    val p = person?.let {
        println("let method person name is ${it.name}, age is ${it.age}")
        Person("new Person", 16)
    }
    println("let method person is $p")
}

private fun also(person: Person?) {
    val p = person?.also {
        println("also method person name is ${it.name}, age is ${it.age}")
        Person("new Person", 16)
    }
    println("also method person is $p")
}

private fun with(person: Person?) {
    with(person) {
        println("with method person name is ${this?.name}, age is ${this?.age}")
    }

    person?.also {
        with(it) {
            println("with method person name is $name, age is $age")
        }
    }
}

private fun run(person: Person?) {
    val p = person?.run {
        println("run method person name is $name, age is $age")
        Person("new Person", 16)
    }
    println("run method person is $p")
}

private fun apply(person: Person?) {
    val p = person?.apply {
        println("apply method person name is $name, age is $age")
        Person("new Person", 16)
    }
    println("apply method person is $p")
}