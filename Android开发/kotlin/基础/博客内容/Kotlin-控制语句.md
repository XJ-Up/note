#### 控制语句

##### 1、条件分支

(1)、简单分支--if...else

kotlin  中  if...else 语句具有返回值，类似于Java中的三目运算

``` kotlin
//传入两个值 a 和 b ,  将大值显示在TextView控件中
nameTextView.text=if(a>b) a else b
```



(2)、多分支

A: 特点

kotlin 中没有 switch/case ，

- 使用 when/else 替代
- when/else 也有返回值
- 执行完一个节点之后就会终止循环
- 分支中判断条件可以是常量/变量/表达式——Java中的switch/case 中 case 节点只能是常量
- 为了确定所有情况都做了判断，通常不能省略else

 

B: 基本使用

```kotlin
var count:Int = 0 btn_when_simple.setOnClickListener {
tv_answer.text = when (count) { 0 -> "值为0"
1 -> "值为1"

else -> "其他值"
}
count = (count+1) % 3
}
```



C: 穿透

java 中 switch/case 需要穿透时需要列出每一个常量条件，但 kotlin中可以简化——                             

- 多个条件直接写在一行，使用 ”,“ 
- 间隔如果条件连续数值，可以通过指定区间范围
- 如果条件是连续数值，并且需要判断不在区间范围内，则使用

```kotlin
btn_when_region.setOnClickListener { tv_answer.text = when (count) {
1,3,5,7,9 -> "取值为13579中的一个"
in 13..19 -> "取值为13到19中的一个"
!in 6..10 -> "取值不再6到10之间" else -> "其他值"
}
count = (count+1) % 20
}

```



D、以表达式为分支条件     

kotlin 中 通过 is 关键字用来判断 A 是否为  B 的实例—— ，等同于 Java中的   A instance B              .

``` kotlin
var countType:Number; btn_when_instance.setOnClickListener {
count = (count+1) % 3 countType = when (count) {
0	-> count.toLong();
1	-> count.toDouble() else -> count.toFloat()
}

tv_answer.text = when (countType) { is Long -> "Long类型"
is Double -> "Double类型" else -> "其他类型"
}
}
```



2、循环处理

(1)、遍历循环

即 for-in 、forEach、 迭代器的使用

(2)、条件循环

满足某个条件时执行/终止循环。

A: 使用关键字

为此，新增了多个关键字：until、setp、downTo

```kotlin
// 遍历11到66之间的数值，until 声明了一个左闭右开的区间——不包含66，包含11 for (i in 11 until 66) {
...
}

//     遍历23-89之间的数值，步进为4——每次+4。23..89声明一个左右均闭合的区间
for (i in 23..89 step 4) {
...
}

//倒序遍历从50到7
for (i in 50 downTo 7) {
...
}
```



B: 使用while、do/while

由于关键字有限，能实现的效果有限，所以，更复杂的逻辑可以使用 while 或 do/while实现

``` kotlin
btn_repeat_begin.setOnClickListener { var poem:String=""
var i:Int = 0
while (i < poemArray.size) { if (i%2 ==0) {
poem = "$poem${poemArray[i]}\n"
} else {
poem = "$poem${poemArray[i]}\n"
}
i++
}
poem = "${poem}该诗歌一共有${i}句" tv_poem_content.text = poem
}
```

```kotlin
btn_repeat_end.setOnClickListener { var poem:String=""
var i:Int = 0 do {
if (i%2 ==0) {
poem = "$poem${poemArray[i]}\n"
} else {
poem = "$poem${poemArray[i]}\n"
}
i++
} while (i < poemArray.size)

poem = "${poem}该诗歌一共有${i}句" tv_poem_content.text = poem
}
```



(3)、中断循环

使用  break——中断循环、continue——跳过本次循环，基本用法同Java，  

另外，当嵌套循环时，还可以通过 @循环标签名  指定要中断的循环。

```kotlin
btn_repeat_break.setOnClickListener { var i:Int = 0
var is_found = false
// outsize@ 表示为外层循环添加标签，名称为 outside outside@ while (i < poemArray.size) {
var j:Int = 0
var item = poemArray[i]; while ( j < item.length) { if (item[j] == '一') { is_found = true
//中断标签名为outside的循环 break@outside
}
j++
}
i++
}
```



3、空处理

(1)、字符串的有效性判断

校验空字符串的方法：

- isNullOrEmpty —— 为null或长度为0时返回true。
- isNullOrBlank —— 为null或长度为0或者全是空格，返回true。
-  isEmpty  —— 长度为0时返回true，必须先判断非null
- isBlank —— 长度为0或者全是空格返回true，必须先判断非null 
- isNotEmpty —— 长度大于0时返回true，必须先判断非null 
- isNotBlank  ——  长度大于0并且非空格返回true，必须先判断非null

(2)、声明可空变量

kotlin中默认变量非空，如果需要声明一个可空的变量，则在类型后面追加一个问号？

``` kotlin
ar strCanNull:String?
```



(3)、校验空值的运算符——?、?:、!!

​     ?  表示可空，如果空直接返回null

​     ?:   表示一旦为空返回冒号后面的值，否则返回正常的值

​     !!    表示断言非空(放弃非空判断)。但是，如果做了这个断言，但依旧为null，那么会报空指针。

 ``` kotlin
var length_null:Int? btn_question_dot.setOnClickListener {
	//strB后面跟了一个”?“表示可null，如果为null则直接返回null,   此时   length_null的值为null
	length_null = strB?.length
	tv_check_result.text = "追加 ? 调用对象属性时得到的长度为 $length_null"
}
 ```

```kotlin
btn_question_colon.setOnClickListener {
	//如果strB非null，返回正常的 strB.length; 如果strB为null，则返回-1 
    length = strB?.length ?: -1
	tv_check_result.text = "使用 ?: 调用对象属性时得到的长度为 $length"
}
```

```kotlin
btn_exclamation_two.setOnClickListener {
    strB = "ABCDE"
	//只有百分百确定非null时，才使用!!,否则依旧会报空指针 	length = strB!!.length
	tv_check_result.text   = "使用!!断言时得到的属性值长度为$length"
}
```



4、等式判断

(1)、结构相等

- kotlin中使用 == 判断两个数据是否相等，使用 != 判断是否不相等。
- kotlin中的String也是使用这种方式。Java中使用equals()
- kotlin中比较字符串时不再比较在内存中的存储地址，而是直接比较变量值     ，这种方式就被叫做    结构相等，即模样相同/外观相同。

(2)、引用相等

如果需要判断引用是否相等，也就是判断内存地址是否一致，kotlin中使用   ===，如果判断不一致，则使用   ！==

- 对于基本数据类型(包括字符串)，结构相等和引用相等一致。
- 通过 clone 得到的对象即便属性值一样，但引用地址不一致。

(3)、is 和 in

- is 和 !is —— 判断A是否为B的实例,如：  对象名 **is**  类名
-  in 和 !in —— 判断数组中是否包含某个元素，如   变量名 **in**   数组名