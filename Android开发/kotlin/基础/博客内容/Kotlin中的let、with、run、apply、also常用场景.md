> 常见场景的使用

- let

##### 处理需要针对一个可null的对象统一做判空处理 

```kotlin
  private var textView: TextView? = null
        //没使用 let前 每一个都需要 加 ？
        var text = textView?.text
        textView?.setTextColor(Color.BLACK)
        
        //使用 let后  只需加一次
        textView?.let { 
            var text1 = it.text
            it.setTextColor(Color.BLACK)
        }
```

- with

##### 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可 

```kotlin
   var  bean=Bean("小米",12)
        //没使用 with前
        var s1=bean.name+bean.age
        //使用with后
        with(bean){
            var  s="$name$age"
        }
```

- run

##### 适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理

- apply 

##### 整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身，而run函数是一个闭包形式返回，返回的是最后一行的值。正是基于这一点差异它的适用场景稍微与run函数有点不一样。apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。 

- also

##### 适用于let函数的任何场景，also函数和let很像，只是唯一的不同点就是let函数最后的返回值是最后一行的返回值而also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用



 

