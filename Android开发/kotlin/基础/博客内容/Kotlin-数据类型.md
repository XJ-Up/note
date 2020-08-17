#### 数据类型

###### 1、基本数据类型

- 基本类型

  ​	Int、Long、Float、Double、Boolean、Char、String

- 类型之间的转换

  ​	toInt()、toLong()、toFloat()、toDouble()、toBoolean()、toChar()、toString()

###### 2、数组

 (1)、数组的声明

- 基本数据类型数组的声明：

  ​	intArrayOf(...)、longArrayOf(...)、floatArrayOf(...)、booleanArrayOf(...)、charArrayOf(...)

- String类型数组的声明

  ​	String是一个特殊的基本数据类型，使用   arrayOf(...)   方法初始化数组。

  例如：

  ``` kotlin
  val strArray : Array<String> = arrayOf("小木","小新","小军")
  ```

  

  其他基本数据类型也可以使用  arrayOf(...) 初始化对应的数组。

(2)、数组元素操作

- 数组长度：

  ​	通过   

  ``` k
   array.size()
  ```

    获取

- 获取/修改元素

   除了  array[index]  模式，也可以通过 set()/get()  获取和修改元素

 

3、字符串

(1)、字符串操作

- 查找——indexOf()
- 截取——substring()
- 替换——replace()
- 分割——split()

注意： Java中 split()返回的是一个String[], 而 kotlin中返回的是一个 List

(2)、字符串模板和拼接

- 占位符 ${...}

    ``` kotlin
    val str="我叫${user.name}"
    ```

  

(3)、如何显示货币符号$

- 方式1：${‘＄’}

  ${}  还是字符串占位格式，其中包含的＇＄＇表示  ＄ 符号 

  ``` kotlin
  val    str="人民币转换后的美元金额为${'$'}$rmbNum"
  ```

  

- 方式2：＼$

  \表示转义，＼＄转义后得到  ＄

  ``` kotlin
  //\S  表示转义获取$符号，$rmbNum 为字符串占位符
  val str="人民币转换后的美元金额为\$ $rmbNum"
  ```

  

##### 4、容器

(1)、容器的基本操作

A: 分类：

分为可变和不可变，可变就是能执行增删改查操作的。

 

- 不可变的容器：Set、List、HashMap
- 可变的容器：MutableSet、MutableList、MutableHashMap

B: 通用方法

- isEmpty —— 是否为空
- isNotEmpty —— 是否非空 
- clear —— 清空容器
- contains  —— 是否包含指定元素
- count —— 获取元素个数/ 也可以通过 size 获取

 

C: 容器初始化

kotlin中的容器可以在定义的时候就执行初始化赋值操作。容器初始化的函数如下：

- listOf()、mutableListOf()
- setOf()、mutableSetOf()
- mapOf()、mutableMapOf()

 

(2)、Set/MutableSet

 

A: 特点

- 内部元素无序
- 内部元素唯一（通过哈希值判断是否唯一，重复则覆盖）
- set不可变，MutableSet可变（所以，后面的几个特点是针对MutableSet的）
- MutableSet中的  add  方法仅添加元素，但不知道添加到了哪个位置
- MutableSet没有修改元素值的方法，元素被添加之后不可被修改
- MutableSet的  remove  方法仅接收元素作为参数，不能接收索引——因为Set无序没有索引

 

B: 遍历

有三种遍历方式：for-in 、 迭代器、  forEach

 

- for-in

  ``` kotlin
for(user in userSet){
...
}

  ```

 

迭代器

 ``` kotlin
val iterator=userSet.iterator() while(iterator.hasNext()){
val user=iterator.next()
...
}

 ```

 

迭代器中存储的并非真实的元素，而是元素的地址，类似于C中的指针。

 

- forEach

使用默认的 it 代表内部元素。

 ``` kotlin
userSet.forEache{"用户的姓名为${it.name}"}
 ```

 

(3)、List/MutableList

A: 特点

- 有序有索引
- 能够通过set修改元素值，能够通过get获取元素值通过add方法添加元素
- removeAt可以删除指定索引位置的元素

 

B: 遍历方式

除了  for-in  、迭代器、forEach, 还有一种根据索引遍历的方式：

 ``` kotlin
// indices 表示userList的索引数组。这种方式本质上也是采用了for-in, 但遍历的是索引
for(i in userList.indices){ val user=userList[i]
...
}
 ```



C: 排序

MutableList  可以执行排序的操作：

 

- sortBy 按照规则升序排列
- sortByDescending 按规则降序排列

``` kotlin
userNameList.sortBy{it.length}
```



(4)、Map/MutableMap

A: 特点

- 以键值对的形式存储元素，键唯一

B: 初始化

调用  mapOf  /  mutableMapOf 执行初始化，在组织键值对元素时都有如下两种方式：

 

- 键 to 值
- Pair(键,值)

 ``` kotlin
val userMap:Map<String,String>=mapOf("姓名" to “张三” , “性别” to "女")

val  userMAp2:MutableMap<String,String>=mutableOf(Pair("姓名",“张三”), Pair("性别",“女"))

 ```

to  模式底层也是使用 Pair()对象构建的。



C: 常用方法

- containsKey 是否包含某个键
- containsValue 是否包含某个值
- put  方法用来修改或添加元素
- remove 根据键名删除值——删除元素

 

D: 遍历

三种模式：for-in 、 迭代器、 forEach

由于元素是一个键值对，所以，在遍历获取到元素之后可以视需要根据元素取出对应的key   和  value

``` kotlin
for(item in userMap){
val str="用户的${item.key} 为 ${item.value}"
}
```

