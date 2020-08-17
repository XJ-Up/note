> Kotlin尾递归函数理解

- **kotlin中，如果某个函数的末尾又调用了函数自身，这种就称为尾递归函数。**

- **尾递归函数需要在 fun 前面添加 tailrec。**

- **尾递归函数会使用循环的方式替代递归，从而避免栈溢出。**    

- **尾递归不能在异常处理的位y、 catch 、 finally 块中使用 。**

  

  #### 例子：

  > 求余弦不动点    

  ```kotlin
  tailrec fun findFixPoint(x: Double = 1.0): Double
  = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))
  ```

  #### 再例如：

  > 计算阶乘的函数。    

  ```kotlin
  ／／定义计算阶乘的函数
  fun fact (n : Int) : Int{
  if (n == 1) {
  return l
  } else {
  return n * fact(n - 1)
  }
  }
  ```

  **上面函数将调用自身作为其执行体的最后一行代码，且递归调用后没有更多代码，因此可 以将该函数改为尾递归语法。此时，上面函数可改为如下形式**

  ```kotlin
  ／／使用尾递归函数的语法
  tailrec fun factRec(n: Int, total : Int= 1): Int =
  if (n == 1) total else factRec(n - 1 , total * n)
  ```

  #### 优势

  与普通递归相比，编译器会对尾递归进行修改，将其优化成一个快速而高效的基于循环的 版本，这样就可以减少可能对内存的消耗。    

  

  ​    

  ​    

