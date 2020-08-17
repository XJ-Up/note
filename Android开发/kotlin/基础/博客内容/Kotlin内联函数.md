> Kotlin中的内联函数还是挺好玩的

- 为什么需要内联函数？    

  **lambda 表达式会被正常地编译成匿名类。这表示每调用一次 lambda表达式，一个额外的类就会被创建。 并且如果 lambda捕捉了某个变量, 那么每次调用的时候都会创建一个新的对象。 这会带来运行时的额外开销，导致使用 lambda 比使用一个直接执行相同代码的函数效率更低 。**

- 内联函数的作用是啥？    

  **能够消除 lambda带来的性能开销， 还能够使 lambda 内的控制流更加灵活. 内联函数使用 inline 修饰符标记，内联函数在 被使用的时候编译器并不会生成函数调用的代码，而是使用函数实现的真实代码替换每一次的函数调用**    

- 内联函数如何运作？   

  **当一个函数被声明为 inline 时，它的函数体是内联的一一换句话说，函数体会被直接替换到函数被调用的地方，而不是被正常调用。来看一个例子以 便理解生成的最终代码 ** 

- 

  > 例如：

  ```kotlin
  inline fun <T> synchronized(lock: Lock, action: () -> T): T {
  lock.lock()
  try {
  return action()
  } finally {
  lock.unlock()
  }
  } f
  un main(args: Array<String>) {
  println("执行 synchronized 之前")
  val lock: Lock = TestLock()
  synchronized(lock) {
  println("do cus action--inline")
  } p
  rintln("执行 synchronized 之后")
  }
  ```

  **因为 synchronized 函数是内联的，编译时不会构建匿名对象，所以， 上述main函数编译之后的字节码等同于：**

  ```kotlin
  fun main(args: Array<String>) {
  println("执行 synchronized 之前")
  val lock: Lock = TestLock()
  //内联函数体
  lock.lock()
  try {
  println("do cus action--inline")
  } finally {
  lock.unlock()
  } p
  rintln("执行 synchronized 之后")
  }
  ```

- 使用 inline 关键字只能提高带有 lambda 参数的函数的性能，    

> 例如

```kotlin
fun setArrayNumber(array:Array<Number>) {
var str:String = "数组元素依次排列"
for (item in array) {
str = str + item.toString() + ", "
} t
v_function_result.text = str
}
```

**Kotlin中Int、Long、Double都继承自Number,但是，如果我们在调用上面的函数时，传入了Array，这样是会报错的！！这一点与JAVA不一致。因为 kotlin中在调用函数时要求参数类名必须完全一致！！**

> **对于上面的函数，如果我们想既可以接收 Array, 也可以接收Array, 那么就可以定义一个具体化类型参数的内联函数. 只有内联函数才可以具体化类型 参数（限定参数类型）**

    ```kotlin
//fun前面加了inline表示内联函数, <reified param:Number> 表示param需要是 Number的子类
inline fun<reified param:Number> setArrayNumber2(array:Array<param>) {
var str:String = "数组元素依次排列"
for (item in array) {
str = str + item.toString() + ", "
} p
rintln(str)
}
    ```

> 调用

```kotlin
var int_array:Array<Int> = arrayOf(1, 2, 3)
var float_array:Array<Float> = arrayOf(1.0f, 2.0f, 3.0f)
var double_array:Array<Double> = arrayOf(11.11, 22.22, 33.33)
btn_generic_number.setOnClickListener {
when (count%3) {
0 -> setArrayStr<Int>(int_array)
1 -> setArrayStr<Float>(float_array)
else -> setArrayStr<Double>(double_array)
} c
ount++
}
```

### 特别要注意的是：

内联函数在调用的时候会在调用出把该函数的代码直接复制一份，调用10次就会复制10次，而并非普通函数一样直接引用函数地址。    

