> 下面我们来说说 Kotlin中的高阶函数

**Kotlin 不是纯粹的面向对象语言， Kotlin 的函数也是一等公民，因此函数本身也具有自己 的类型 。 函数类型就像前面介绍的数据类型一样，既可用于定义变量，也可用作函数的形参类 型，还可作为函数的返回值类型     **

- 使用函数类型    

Kotlin 的每个函数都有特定的类型，函数类型由函数的形参列表、 ·＞和返回值类型组成 。 例如如下函数 ：    

```kotlin
fun foo(a : Int , name:String) ->String{
		....
}
```

该函数的形参列表、－＞和返回值类型为（Int , String) -> String，这就是该函数的类型。    

```kotlin
fun bar(width : Double , height: Double) {
		....
}
```

该函数的形参列表、 ．＞和返回值类型为(Double , Double)-> Unit 或（Double, Double），这就 是该函数的类型。    

```kotlin
fun test() {
	....
}
```

该函数的形参列表、 ·＞和返回值类型为（） －＞Unit 或（），这就是该函数的类型 。    

##### 例如：

```kotlin
//定义一个变量，其类型为（ Int, Int) - > Int
var myfun : (Int , Int) -> Int
//定义一个变盘，其类型为（ Stri口 g)
var test : (String)
```

定义了函数类型的变量之后，就可以将函数赋值给该变量。 

```kotlin
//定义一个计算乘方的函数
fun pow (ba$e: Int , exponent: Int) : Int {
var result = 1
for ( i in 1 . . exponent) {
result *= base
return result
//将 pow 函数赋值给 my fun ，则 my fun 可当成 pow 使用
myfun = ::pow
println(myfun(3 , 4)) //输出 81
//定义一个计算面积的函数
fun area(width: Int , height : Int) : Int {
return width * height
//将 area 函数赋值给 my fun ，则 myfun 可当成 area 使用
myfun = : : area
println(myfun(3,4)）//输出 12
```

   依次将 pow（）、 area（）函数赋值给 myfun 变量———只要被赋值 的函数类型与 myfun 的变量类型一致，就可以赋值成功。    

> 当直接访问一个函数的函数引用，而不是调用函数时，需要在函数名前添加两个冒号，而 且不能在函数后面添加圆括号一一 一旦添加圆括号，就变成了调用函数，而不是访问函数引用。 通过使用函数类型的变量，可以让 myfun在不同的时间指向不同的函数，从而让程序更 加灵活 。 由此可见，使用函数类型的好处是让程序更加灵活。 除此之外，程序还可使用函数类型作为形参类型和返回值类型。    

- 使用函数类型作为形参类型    

Kotiin 支持像使用其他类型一样使用函数类型，因此完全可以在函数中定义函数类型的形 参 

##### 例子

```kotlin
//定义函数类型的形参，其中 fn 是（ Int ）→ Int 类型的形参
fun map (data : Array<Int>, fn: (Int) -> Int) : Array<Int> {
    var result = Array<Int>(data.size, { 0 })
//遍历 data 数组的每个元素，并用 fn 函数对 data[i ］进行计算
//然后将计算结果作为新数组的元素
    for (i in data.indices) {
        result[i] = fn(data[i])
    }
    return result
}
    //定义一个计算平方的函数
    fun square (n : Int) : Int {
        return n *n
        //定义一个计算立方的函数
        fun cube(n : Int) : Int {
            return n * n * n
        }
            //定义一个计算阶乘的函数
            fun factorial (n: Int ) : Int {
                var result = 1
                for (index  in 2 .. n) {
            result *= index
            return result
        }
                fun main(args : Array<String>) {
                    var data= arrayOf (3 , 4 , 9 , 5 , 8)
                    println("原数据${data.contentToString()}")
                    //下面程序代码调用 map （）函数 3 次 ， 每次调用时都传入不同的函数
                    println("计算数组元素的平方")
                    println(map(data,::square).contentToString())
                    println("计算数组元素的立方")
                    println(map((data,::cube).contentToString())
                    println("计算数组元素的阶乘")
                    println(map(data,::factorial).contentToString())

                    }
```

**定义了一个 map（）函数，该函数的第二个参数是一个函数类型的形参，这意味 着每次调用函数时都可动态传入一个函数，随着实际传入函数的改变，就可以动态改变 map() 函数中的部分计算代码 。**    

**map（）函数 3 次， 3 次调用时依次传入了 square、 cub e 、 fac toria l 函数作为参数 ， 这样每次调用 map（）函数时实际的执行代码都是有区别的 **    

- 使用函数类型作为返回值类型    

> Kotlin 还支持定义函数类型的返回值，这样即可将其他函数作为函数的返回值   

##### 例子

```kotlin
//定义函数，该函数的返回值类型l'l (Int)• Int
fun getMathFunc(type: String): (Int) -> Int {
    //定义一个计算平方的局部函数
    fun square(n: Int): Int {
        return n * n
    }

    //定义一个计算立方的局部函数
    fun cude(n: Int): Int {
        return n * n * n
    }

    //定义一个计算阶乘的局部函数
    fun factorial(n: Int): Int {
        var result = 1
        for (index in 2..n) {
            result *= index

        }
        return result
    }
    when (type) {
        //返回局部函数
        "square" -> return ::square
        "cube" -> return ::cude
        else -> return ::factorial
    }

}

fun main(args: Array<String>) {
    //调用 getMathFunc （），程序返回一个（ Int ）→ Int 类型的函数
    var mathFunc = getMathFunc("cube")//得到 cube 函数
    println(mathFunc(5)) //输出 125
    mathFunc = getMathFunc("square") //得到j square 函数
    println(mathFunc(5)) //输出 25
    mathFunc = getMathFunc("other")//得到 factorial 函数
    println(mathFunc(5)) //输出 120
}
```

