package com.xiajun.kt

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

/**
 * Created by ChenS on 2019/6/11.
 * chenshichao@outlook.com
 */
fun doInBackground() {
    println("start.")
    GlobalScope.launch {
        delay(1000)
        println("Hello, threadId=${Thread.currentThread().id}")
    }
    Thread.sleep(3000)
    println("end, threadId=${Thread.currentThread().id}")
}

fun doInBackground2() {
    println("start.")
    GlobalScope.launch {
        delay(1000)
        println("Hello, threadId=${Thread.currentThread().id}")
    }

    runBlocking {
        delay(3000)
        println("Hello2, threadId=${Thread.currentThread().id}")
    }

    Thread.sleep(3000)
    println("end, threadId=${Thread.currentThread().id}")
}

fun createCoroutines() {
    thread(start = true) {
        var c = AtomicInteger()
        for (i in 1..1_000_000) {
            GlobalScope.launch {
                c.addAndGet(i)
            }
        }

        println("${c.get()}, coroutines.")
    }
}

fun createThreads() {
    thread(start = true) {
        var c = AtomicInteger()
        for (i in 1..1_000_000) {
            thread(start = true) {
                c.addAndGet(i)
            }
        }

        println("${c.get()}, threads.")
    }
}

fun createAsyncCoroutines() {
    thread(start = true) {
        val deferred = (1..1_000_000).map { n ->
            GlobalScope.async {
                n
            }
        }

        runBlocking {
            var sum = deferred.sumBy { it.await() }
            println("sum=$sum")
        }
    }
}

fun main(args: Array<String>) {
//    doInBackground()
//    doInBackground2()

//    createCoroutines()
//    createThreads()
    createAsyncCoroutines()
}