> Kotlin中的泛型和java中的十分类似都是用T表示泛型

- kotlin中使用 T 表示泛型。 

- 在定义泛型函数时需要在 fun 后面加入 , 然后指明某个参数的类型为 T 泛型函数的定义： 

  ```kotlin
    //Kotlin中允许定义全局函数，将函数定义在kt文件中，然后全局可调用 
      fun <T> appendString(tag: String, vararg otherInfo: T?): String {
          var str: String = "$tag:" for (item in otherInfo) {
              //遍历可变数组，然后拼接 
              str = "$str${item.toString()},"
          }
          return str
      }
  ```

  泛型函数的调用： 

  ```kotlin
   var count = 0
      btn_vararg_generic.setOnClickListener
      {
          tv_function_result.text = when (count % 3) {
  //在定义泛型函数时，需要指明T的类型
              0 -> appendString<String>("中国四大发明", "造纸术", "火药", "印刷术", "指南针")
              1 -> appendString<Int>("小于10的素数", 2, 3, 5, 7)
              else -> appendString<Double>("花钱的日子", 5.20, 6.18, 11.11, 12.12)
          } c
                  ount++
      }
  ```

  