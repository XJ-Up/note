> Kotlin 中的 扩展 到底是什么？

#### 简单使用：

- 扩展函数    

```kotlin
//要扩展哪个类中的方法，被扩展的类名就是哪个
fun 被扩展的类名.扩展函数名(..参数..){
函数体
}
```

##### 例如：

在Array中扩展一个元素交换的方法 

```kotlin
fun Array<Int>.swap(pos1: Int, pos2: Int) {
//this表示当前数组本身
val tmp = this[pos1]
this[pos1] = this[pos2]
this[pos2] = tmp
}
```

#### 高级点用法：

- 使用 T 标记泛型

**改写上面的扩展函数**

```kotlin
fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
val tmp = this[pos1]
this[pos1] = this[pos2]
this[pos2] = tmp
}
```

之前的扩展方法，只适用于Array ,现在适用于 Double、Float等类型

- 扩展高阶函数    

##### 例子：一个求数组元素中最大值   扩展Array 类     

```kotlin
fun <T> Array<T>.maxCustomize(greater: (T, T) -> Boolean): T? {
var max: T? = null
//this表示 Array<T>本身
for (item in this)
if (max == null || greater(item, max))
max = item
return max
}
```

> 看到这里是不是很简单，那么到底什么是扩展呢？

**Kotlin 的扩展是一个很独特的功能， Java 本身并不支持扩展， Kotlin 为了让扩展能在JVM平台上运行，必须做一些独特的处理 **

**Kotiin 支持扩展方法和扩展属性 **

> #### 扩展的实现机制      

**Java 是一 门静态语言。一个类被定义完成之后，程序无法动态地为该类增加、 删除成员（ field、方法等），除非开发者重新编辑该类的源代码，并重新编译该类。 但现在 Kotlin 的扩展却好像可以动态地为一个类增加新的方法，而且不需要重新修改该 类的源代码，那 Kotlin 扩展的实际情况是怎样的呢？难道 Kotlin 可以突破 NM 的限制？ 实际上， Kotlin 的扩展并没有真正地修改所扩展的类，被扩展的类还是原来的类，没有任 何改变。 Kotiin 扩展的本质就是定义了 一个函数，当程序用对象调用扩展方法时， Kotlin 在编 译时会执行静态解析一一就是根据调用对象、方法名找到扩展函数，转换为函数调用**

> 扩展的作用主要有两个方面     

- 扩展可动态地为己有的类添加方法或属性 。    
- 扩展能以更好的形式组织一些工具方法 。   

##### 扩展是一种非常灵活的动态机制，它既不需要使用继承，也不需要使用类似于装饰者的任何设计模式，即可为现有的类增加功能，因此使用非常方便。    

