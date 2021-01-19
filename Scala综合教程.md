# Scala综合教程

## 1.Scala 介绍

### 1.1 什么是 Scala Scala

是一种多范式的编程语言，其设计的初衷是要集成面向对象编程和函数式编程的各种特性 。Scala 运 行 于Java平台（ Java 虚 拟 机 ）， 并 兼 容 现 有 的 Java 程 序 。

### 1.2 为什么要学 Scala

1. 优雅：这是框架设计师第一个要考虑的问题，框架的用户是应用开发程序员，API 是否优 雅直接影响用户体验。
2. 速度快：Scala 语言表达能力强，一行代码抵得上 Java 多行，开发速度快；Scala 是静态编 译的，所以和 JRuby,Groovy 比起来速度会快很多。
3. 能融合到 Hadoop 生态圈：Hadoop 现在是大数据事实标准，Spark 并不是要取代 Hadoop， 而是要完善 Hadoop 生态。JVM 语言大部分可能会想到 Java，但 Java 做出来的 API 太丑，或者想实现一个优雅的 API 太费劲。

### 1.3 Scala 特性

* 面向对象特性

Scala是一种纯面向对象的语言，每个值都是对象。对象的数据类型以及行为由类和特质描述。

类抽象机制的扩展有两种途径：一种途径是子类继承，另一种途径是灵活的混入机制。这两种途径能避免多重继承的种种问题。

* 函数式编程

Scala也是一种函数式语言，其函数也能当成值来使用。Scala提供了轻量级的语法用以定义匿名函数，支持高阶函数，允许嵌套多层函数，并支持柯里化。Scala的case class及其内置的模式匹配相当于函数式编程语言中常用的代数类型。

更进一步，程序员可以利用Scala的模式匹配，编写类似正则表达式的代码处理XML数据。

* 静态类型

Scala具备类型系统，通过编译时检查，保证代码的安全性和一致性。类型系统具体支持以下特性：泛型类；协变和逆变；标注；类型参数的上下限约束；把类别和抽象类型作为对象成员；复合类型；引用自己时显式指定类型；视图；多态方法。

* 扩展性

Scala的设计秉承一项事实，即在实践中，某个领域特定的应用程序开发往往需要特定于该领域的语言扩展。Scala提供了许多独特的语言机制，可以以库的形式轻易无缝添加新的语言结构：任何方法可用作前缀或后缀操作符；可以根据预期类型自动构造闭包。

* 并发性

Scala使用Actor作为其并发模型，Actor是类似线程的实体，通过邮箱发收消息。Actor可以复用线程，因此可以在程序中可以使用数百万个Actor,而线程只能创建数千个。在2.10之后的版本中，使用Akka作为其默认Actor实现。

## 2.开发环境准备

### 2.1 ScalaSDK 安装

安装 ScalaSDK前 ,请 确 保 已 安 装 JDK1.8+.

### 2.1.1Window 下安装 ScalaSDK

访问 Scala 官网 https://www.scala-lang.org/download/all.html下载 Scala 编译器安装包，目前大多数的框架都是用 2.11.x 编写开发的，Spark2.x 使用的就是 2.11.x，所以这里推 荐 2.11.x 版本，下载 scala-2.11.8.msi 后点击下一步就可以了。scala-2.11.8.zip需要自己配置环境变量

### 2.1.2Linux 下安装 ScalaSDK

下载 Scala 地址https://www.scala-lang.org/download/2.12.8.html 然后解压 Scala 到 指定目录 tar -zxvfscala-2.11.8.tgz -C /usr/java 配置环境变量，将 scala 加入到 PATH 中 vi/etc/profile

```shell
exportJAVA_HOME=/usr/java/jdk1.8.0_111
exportPATH=$PATH:$JAVA_HOME/bin:/usr/java/scala-2.11.8/bin
```

## 3.基本语法

### 3.1 数据类型

Scala 和 Java 一样，有 7 种数值类型 Byte、Char、Short、Int、Long、Float 和 Double（无包装类型）和 Boolean、Unit 类型.
注意:Unit 表示无值，和其他语言中 void 等同。用作不返回任何结果的方法的结果类型。Unit 只有一个实例值，写成()。

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119151245.png)

### 3.2 变量的定义

```scala
object 变量定义 extends App { 
    /** 
      * 定义变量使用var或者val关 键 字 
      *
      * 语法: 
      *  var | val 变量名称(: 数据类型) =变量值
      */
    // 使用val修饰的变量, 值不能为修改,相当于java中final修饰的变量 
    val name = "tom"
 
    // 使用var修饰的变量,值可以修改 
    var age = 18
 
    // 定义变量时,可以指定数据类型,也可以不指定,不指定时编译器会自动推测变量的数据类型 
    val name2 : String = "jack"
}
```

### 3.3 字符串的格式化输出

```scala
/*
 * Scala 中的格式化输出
 */
 
object ScalaPrint extends App {
 
  val name = "JackMa"
  val price = 998.88d
  val url = "www.baidu.com"
  // 普通输出,注意这里是可以使用逗号分隔的，但是在java中，我们是需要用“+”号拼接
  println("name=" + name,"price="+price,"url="+url)
 
  // 'f'插值器允许创建一个格式化的字符串，类似于C语言中的printf。
  // 在使用'f'插值器时，所有变量引用都应该是printf样式格式说明符，如％d ,％i ,％f等 。
  // 这里$name％s打印String变量name,
  println(f"姓名：$name%s,价格：$price%1.2f,网址：$url%s")
  println(f"姓名：%%s,价格：%%1.1f,网址：%%s",name,price,url)
 
  // 's'插值器允许在字符串中直接使用变量
  // 下列语句中将String型变量（$name）插入到普通字符串中
  println(s"name=$name,price=$price,url=$url")
 
  //'s'插值器还可以处理任意形式的表达式
  println(s"1+1=${1+1}") //output "1+1=2"
}
```

## 3.6 条件表达式

```scala
/*
 * Scala if条件表达式
 */
object ScalaIf extends App {
   //if语句的使用
    var faceValue=98
    var res1=if (faceValue>90) "帅的一批" else "有点恼火"
    print(res1)
 
    //3>5 不成立，且代码没有else分支，那么res2应该输出什么呢？
    var i=3
    var res2=if (i>5) i
    print(res2)// output  ()代表空
 
    // 支持嵌套，if...else if ...else代码过多时可以使用{}
    val score=85
    if(score<60)"不及格"
    else if(score>=60&&score<70)"及格"
    else if (score>=80&&score<90)"优秀"
    else "优秀"
}
```

## 3.7 循环语句和yeild 关键字

```scala
/*
 * Scala for循环
 */
object ScalaFor extends App {
    //  定一个数组
    var arr=Array(1,2,3,4,5,6)
 
    //遍历数组中么个元素
    for(ele <- arr){
      print(ele)
    } /*output:1 2 3 4 5 6*/
 
    // 0 to 5 =>会生成一个范围集合Range（0,1,2,3,4,5),左闭右闭
    for(i <- 0 to 5){
      print(i) /*output:0,1,2,3,4,5*/
    }
 
    // 0 until 5 =>会生成一个范围集合Range（0,1,2,3,4)，左闭右开
    for(i <- 0 until 5){
      print(i) /*output:0,1,2,3,4*/
    }
 
    // for循环中可以增加守卫，下面这段语句是打印arr数组中的偶数
    for(i <- arr if i%2==0){
      print(i)
    }/*input:2,4,6*/
 
    //双层for循环
    for (i <- 1 to 3;j <- 1 to 3 if i!=j){
      print(i*10+j+"")
    }/*output:12,13,21,23,31,32*/
 
    // yield 关键字将满足条件的e的值又组合成一个数组
    // 这个操作我感觉应用到数组身上的可操作空间很大
    var arr2=for(e <- arr if e%2==0)
       yield e
    for (i <- arr2){
      print(i)/*output:2,4,6*/
    }
}
```

## 3.8 运算符和运算符重载

Scala 中的+-*/%等操作符的作用与 Java 一样，位操作符 &|^>><<也一样。

只是有 一点特别的：这些操作符实际上是方法。

例如：

a+b

是如下方法调用的简写：

a.+(b)

a 方法 b 可以写成 a.方法(b)

## 3.9 方法的定义与调用

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119205520.png)

方法的返回值类型可以不写，编译器可以自动推断出来，**但是对于递归函数，必须指定返回类型。**

```scala
/*
 * 方法的定义及调用
 * 定义方法的格式为 :
 * def methodName ([listofparameters]) : [ returntype ] = { }
 * 如果不使用等号和方法体，则隐式声明抽象(abstract)方法 。
 */
object ScalaMethod extends App{
  // 定义一个sum方法，该方法有两个参数，返回值为int类型
  def sum(a:Int, b: Int): Int = { a + b }
  // 调用
  val result=sum(1,5)
  print(result)
  // 该方法没有任何参数 , 也没有返回值
  def sayHello1 = print("Say BB1")
  def sayHello2() = print("Say BB2")
  sayHello1 // 如果方法没有()调用时不能加()
  sayHello2() // 可以省略( ) ,也可以不省略
}
```

方法可转换为函数:

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119205944.png)

## 3.10 函数的定义与调用

函数定义方式一:

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119210144.png)

调用:f1(2)，其中 f1 为函数的引用，也可以叫做函数名。function1 表示一个参数的函数。


函数定义方式二:

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119210145.png)

下面为没有任何参数的函数,，函数的返回值为 Int 类型。

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119210146.png)

## 3.11传值调用与传名调用

通常，函数的参数是传值参数；也就是说，参数的值在传递给函数之前就已经确定。

但是， 在 Scala 中，我们方法或者函数的参数还可以是一个表达式，也就是将一个代码逻辑传递给了某个方法或者函数。

```scala
/*
 *scala的
 *      传名调用( call-by-name)
 *      传值调用( call-by-value)
 */
object ScalaCallName  extends App{
 
    def currentTime():Long={
      System.nanoTime();
    }
    // 该方法的参数为一个无参的函数,并且函数的返回值为Long
    def delayed(f: => Long): Unit ={
        print(s"time=${f}")
    }
    
    def delayed2(time: Long): Unit ={
      print(s"time=${time}")
    }
 
    //调用方式一
    delayed(currentTime())
 
    // 调用方式二
    // 等价于调用方式一，本质是先计算出参数的值，在带入方法
    var time=currentTime()
    delayed2(time)
 
}
```

## 3.12 可变参数函数

```scala
/*
 *scala的可变参数 
 */
object ScalaVarParams  extends App{
    //定义一个可变参数方法
    def methodManyParams(params:Int*): Unit ={
      for (i <- params){
        print(i)
      }
    }
   // 调用
    methodManyParams(1,2,3,5)
}
```

## 3.13 默认参数值函数

```scala
/*
 *scala的默认参数
 */
object ScalaDefaultParams  extends App{
    //定义一个默认参数方法
    def add(a:Int=1,b:Int=2): Int ={
       a+b
    }
    // 等价于add(a=3,b=2)
    add(3)
    // 等价于add(a=4,b=5)
    add(4,5)
    // 等价于add(a=1,b=5)
    add(b=5)
}
```

## 3.14 高阶函数

```scala
/*
 *scala的高阶函数
 */
object ScalaHM  extends App{
    //  高阶函数将其他函数作为参数
    def apply(f:Int => Int,p:Int): Unit ={
      print(f(p))
    }
 
    def fn1(a:Int): Int ={
        a*a
    }
    apply(fn1,10)/*output：100*/
}
```

## 3.15 部分参数应用函数

如果函数传递所有预期的参数，则表示已完全应用它。 如果只传递几个参数并不是全部参 数，那么将返回部分应用的函数。这样就可以方便地绑定一些参数，其余的参数可稍后填写 补上。

```scala
/*
 *scala的部分参数
 */
object ScalaPartParams  extends App{
    //定义了一个求和函数
    def sum(a:Int,b:Int): Int ={
         a+b
    }
    // 调用sum函数的时候，传入了一个参数a=10，但是b为待定参数。
    // sumWithTen形成了一个新的函数，参数个数为一个，类型为int型，
    def sumWithTen:Int => Int=sum(10,_: Int)
 
    //sumWithTen(1),本质是sum(10,1)
    print(sumWithTen(1))
}
```

## 3.16 柯里化(Currying)

柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新 的函数返回一个以原有第二个参数为参数的函数。

```scala
/*
 *scala的柯里化
 */
object ScalaCurrying  extends App{
    //定义了一个求和函数
    def add(a:Int,b:Int)=a+b
    // 那么我们在调用的时候，应该是add(1,2)
    // 现在我们将这个函数变形
    def add(a:Int)(b:Int)=a+b
    // 那么我们在调用的是后应该是add(1)(2),其结果还是等于3，这种方式（或过程）就叫做柯里化，
    // 经过柯里化之后函数通用性降低，但是适用性有所提高
    //分析下其演变过程
    def add(a:Int): Int => Int={
      (b:Int)=>a+b
    }
    //(b:Int)=>a+b 为一个匿名函数，也就意味着add方法的返回值为一个匿名函数，
    // 那么现在的调用过程为
    var result=add(1)
    var sum1=result(2)
 
}
```

## 3.17 偏函数

被包在花括号内没有 match 的一组 case 语句是一个偏函数，它是 PartialFunction[A,B]的一个 实例，A 代表参数类型，B 代表返回类型，常用作输入模式匹配。

```java
/*
 *scala的偏函数
 */
object ScalaPartialFunc  extends App{
    /*
     *PartialFunction[A,B]，A 代表参数类型，B 代表返回类型，常用作输入模式匹配。 
     */
    def fun1:PartialFunction[String,Int]={
      case "one" => 1
      case "two" => 2
      case _ => -1
    }
}
```

# 4.集合的使用

Scala 的集合有三大类：序列 Seq、集 Set、映射 Map，所有的集合都扩展自 Iterable 特质 在 Scala 中集合有可变（mutable）和不可变（immutable）两种类型，immutable 类型的集合 初始化后就不能改变了（注意与 val 修饰的变量进行区别。

![img](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119210147.png)

## 4.1 定长数组和变长数组

```scala
/*
 *scala数组
 */
import scala.collection.mutable.ArrayBuffer
object ScalaArray{
  def main(args: Array[String]): Unit = {
    // 初始化一个长度为8的定长数组,所有元素均为0
    val arr=new Array[Int](8)
    // 直接打印数组的到的是数组的hashcode值
    print(arr)
    // 将数组转换成数组缓冲，就可以看到数组中内容
    print(arr.toBuffer)
    // 定义一个长度为3的定长数组
    val arr2=Array("tom","jack","oliver")
    // 通过索引获取数组中的值
    print(arr2(1))
    // 创建一个变长数组
    var arr3=ArrayBuffer[Int]()
    // 末尾追加1
    arr3+=1
    //  追加多个元素
    arr3+=(2,3,4,5)
    //  追加一个数组
    arr3++=Array(6,7)
    //  追加一个变长数组
    arr3++=ArrayBuffer(8,9)
    //  打印
    arr3.foreach(print)
    // 在某个位置插入元素
    arr3.insert(0,-1,0)
    //  移除指定索引元素
    arr3.remove(0,1)
  }
}
```

## 4.2 map|flatten|flatMap|foreach 方法的使用

```scala
object ScalaArray{
  def main(args: Array[String]): Unit = {
    val arr=Array(1,2,3,4,5)
    // map函数将arr数组中所有元素进行某种映射操作，
    // (x:Int)=>x*2为一个匿名函数，x就是数组中的每个元素
    val z= arr map((x:Int)=>x*2)
    // 或者这样写，编译器会推断数据的类型
    val y=arr.map(x=>x*2)
    // 亦或者，_表示入参，代表数组中每个元素
    val x=arr.map(_ * 2)
    
    println("--------骚气分割线-----------")
 
    val words=Array("tom jack oliver jack","hello tom oliver tom ")
    // 将words中元素按照“，”切分
    val splitWords: Array[Array[String]] = words.map(x=>x.split(","))
    //此时数组中的每个元素进行split操作之后变成了Array,
    // flatten是对splitWords里面的元素进行扁平化操作
    val flatten: Array[String] = splitWords.flatten
 
    // 上诉两步操作可以等价于flatmap，意味着先map操作之后进行flatten操作
    val result=words.flatMap(_ .split(","))
    
    // 遍历数组，打印每个元素
    result.foreach(print)
  }
}
```

## 4.3 Seq 序列

不可变的序列 importscala.collection.immutable._

在 Scala 中列表要么为空（Nil 表示空列表）要么是一个 head 元素加上一个 tail 列表。 9::List(5,2) :: 操作符是将给定的头和尾创建一个新的列表

```
object ScalaListTest{
  def main(args: Array[String]): Unit = {
      // 创建一个不可变集合
      val list=List(1,2,3)
      // 创建一个可变集合
      val mutalist=ListBuffer(1,2,3)
      // 将0插入到list前面生成一个新的list
      val list1: List[Int] = list.:+ (0)
      val list2: List[Int] = 0+:list
      val list3: List[Int] = 0::list
      val list4: List[Int] = list.::(0)
      // 将一个元素添加到list后面，形成新的list5
      val list5: List[Int] = list:+(4)
 
      val list6=List(4,5,6)
      // 将两个list合并成一个新的list
      val list7: List[Int] = list++list6
      val list8: List[Int] = list ++: list6
      // 将list6插入到list前面形成一个新的集合
      val list9: List[Int] = list.:::(list6)
      list8.foreach(println)
  }
}
```

## 4.4 Set 集

可变的set

```scala
object ScalaSetTest{
  def main(args: Array[String]): Unit = {
    // 创建一个可变set
    val set: mutable.HashSet[Int] = new mutable.HashSet[Int]()
    // 往set中加入元素1
    set+=1
    // add等价于+=
    set.add(2)
    // 添加另一个set中元素
    set ++= Set(7,8,9)
    // 移除一个元素
    set-=2
    // remove等价于-=
    set.remove(2)
    
    set.foreach(print)
  }
}
```

不可变的set

```scala
object ScalaSetTest{
  def main(args: Array[String]): Unit = {
    // 创建一个不可变set
    val set: HashSet[Int] = new HashSet[Int]()
    // 将元素和原来的set合并生成一个新的set2，原有set不变
    val set2=set+1
    // 两个set合并生成一个新的set
    val set3=set++Set(4,5,6)
    set3.foreach(print)
  }
}
```

## 4.5 集合常用的方法

map, flatten, flatMap, filter, sorted, sortBy, sortWith, grouped, fold(折叠), foldLeft, foldRight, reduce, reduceLeft, aggregate, union, intersect(交集), diff(差集), head, tail, zip, mkString, foreach, length, slice, sum

```scala
scala> val list=List(1,2,3,4,5)
list: List[Int] = List(1, 2, 3, 4, 5)
 
scala> list.map(x=>x*2)
res0: List[Int] = List(2, 4, 6, 8, 10)
 
scala> list.sortBy(x=> -x)
res5: List[Int] = List(5, 4, 3, 2, 1)
 
scala> val words=List(("a",3),("b",5),("c",2))
words: List[(String, Int)] = List((a,3), (b,5), (c,2))
 
scala> words.sortBy(t=> t._2)
res6: List[(String, Int)] = List((c,2), (a,3), (b,5))
 
scala> words.sortWith((x,y)=>x._2>y._2)
res7: List[(String, Int)] = List((b,5), (a,3), (c,2))
 
scala> list.grouped(2).toList
res10: List[List[Int]] = List(List(1, 2), List(3, 4), List(5))
 
scala> list
res13: List[Int] = List(1, 2, 3, 4, 5)
 
scala> list.fold(0)((x,y)=>x+y)
res14: Int = 15
 
scala> list.fold(0)(_+_)
res15: Int = 15
 
scala> list.foldLeft(2)(_ - _)
res18: Int = -13
 
scala> list.foldRight(2)(_ - _)
res19: Int = 1
 
scala> list.reduce((x,y)=> x+y)
res20: Int = 15
 
scala> list.aggregate(0)(_ + _,_ + _)
res21: Int = 15
 
scala> val list=List(1,2,3,4,5)
list: List[Int] = List(1, 2, 3, 4, 5)
 
scala> val list2=List(1,3,5,7,8)
list2: List[Int] = List(1, 3, 5, 7, 8)
 
scala> list.union(list2)
res0: List[Int] = List(1, 2, 3, 4, 5, 1, 3, 5, 7, 8)
 
scala> list.intersect(list2)
res1: List[Int] = List(1, 3, 5)
 
scala> list.diff(list2)
res2: List[Int] = List(2, 4)
 
scala> list.head
res3: Int = 1
 
scala> list.tail
res4: List[Int] = List(2, 3, 4, 5)
 
scala> list.zip(list2)
res5: List[(Int, Int)] = List((1,1), (2,3), (3,5), (4,7), (5,8))
 
scala> list.mkString("|")
res7: String = 1|2|3|4|5
 
scala> list.foreach(print)
12345
 
scala> list.length
res11: Int = 5
 
scala> list.slice(1,3)
res12: List[Int] = List(2, 3)
 
scala> list.sum
res14: Int = 15
```

## 4.6并行化集合 par

调用集合的 par 方法, 会将集合转换成并行化集合

```
object ScalaParTest{
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1,7,9,8,0,3,5,4,6,2)
    val par: ParSeq[Int] = list.par
  }
}
```

## 4.7 Map 和 Option

在Scala中Option类型样例类用来表示可能存在或也可能不存在的值(Option的子类有Some 和 None)。Some 包装了某个值，None 表示没有值。

```scala
object ScalaMapTest{
  def main(args: Array[String]): Unit = {
    val map: Map[String, Int] = Map("a"->1,"b"->2,"c"->3)
    val i: Int = map("d")
    // map的get方法返回值Option，意味着maybeInt可能取到值也可能没有取到值
    val maybeInt: Option[Int] = map.get("d")
    // 如果maybeInt=None时会抛出异常
    val v=maybeInt.get
    // 第一个参数为要获取的key
    // 第二个参数为如果没有这个key返回一个默认值
    val ele: Int = map.getOrElse("d",-1)
  }
}
```

## 4.8 案例 wordCount

```scala
object ScalaWordCount{
  def main(args: Array[String]): Unit = {
      // 第一种方式
      val words=Array("hello tom jack oliver","tom jack jim hello")
      val strings: Array[String] = words.flatMap(_ .split(" "))
      val tuples: Array[(String, Int)] = strings.map((_ ,1))
      val stringToTuples: Map[String, Array[(String, Int)]] = tuples.groupBy(_._1)
      val stringToInt = stringToTuples.mapValues(_.length)
      stringToInt.foreach(print)
      // 第二种方式
      val list= words.flatMap(_.split(" "))//对数组中每个元素进行切分，并进行扁平化操作
        .map((_,1))    // 将数组中每个元素转换成元组，元组第二个元素为1
        .groupBy(_._1) // 将相同单词元组分为一组
        .mapValues(_.length)//对每个key的value集合进行长度操作
        .toList //  转换成list
      list.foreach(print)
      //  第三种方式
      val list2: List[(String, Int)] = words.flatMap(x=>x.split(" ")).groupBy(x=>x).map(t=>(t._1,t._2.length)).toList
      list2.foreach(print)
  }
}
```

# 5. 面向对象

## 5.1 scala 单例对象

在 Scala 中，是没有 static 这个东西的，但是它也为我们提供了单例模式的实现方法，那 就是使用关键字 object,object 对象不能带参数。

```scala
/*
 * 单例对象
 */
object ScalaSingleton{
    def saySomeThing(msg:String): Unit ={
      println(msg)
    }
}
 
object test{
  def main(args: Array[String]): Unit = {
    ScalaSingleton.saySomeThing("hello")
    println(ScalaSingleton)
    println(ScalaSingleton)
    // output:
    // hello
    //ScalaSingleton$@ea4a92b
    //ScalaSingleton$@ea4a92b
  }
}
```

## 5.2 scala 类

### 5.2.1 | 类定义 | 主构造器 | 辅助构造器

类定义

```scala
/*
 * scala中，类并不用声明为public
 * 如果你没有定义构造器，类会有一个默认的空参构造器
 *
 * var 修饰的变量，对外提供setter、getter方法
 * val 修饰的变量，对外只提供getter方法，不提供setter方法
 */
class Student{
  // _表示一个占位符，编译器会根据你变量的类型赋予相应的初始值
  var name:String=_
  // 错误代码，val修饰的变量不能使用占位符
  // val age:Int=_
  val age:Int=10
}
 
object test{
  def main(args: Array[String]): Unit = {
    // 空参构造器可以加（）也可以不加
    val student = new Student()
    student.name="JackMa"
    //  错误代码，类中使用val修饰的变量不能更改
    //  student.age=20
    println(s"name=${student.name},age=${student.age}")
  }
}
```

定义在类后面的为类主构造器, 一个类可以有多个辅助构造器

```java
/*
 * 定义在类名称后面的构造器为主构造器
 * 类的主构造器中的属性会定义成类的成员变量
 * 类的主构造器中属性没有被var|val修饰的话，该属性不能访问，相当于对外没有提供get方法
 * 如果属性使用var修饰，相当于对外提供set和get方法
 */
class Student1(var name:String,val age:Int){
  var gender:String=_
  def this(name:String,age:Int,gender:String){
      this(name,age)
      this.gender=gender
  }
}
 
object test{
  def main(args: Array[String]): Unit = {
    val s1 = new Student1("Tom",18)
    println(s"name=${s1.age},age=${s1.age},gender=${s1.gender}")
    val s2 = new Student1("JackMa",20,"man")
    println(s2.gender)
    // output:
    // name=18,age=18,gender=null
    // man
  }
}
```

### 5.2.2 访问权限

- 构造器的访问权限

```scala
/*
 * private 加在主构造器之前，这说明该类的主构造器是私有的，外部对象或者外部类不能访问
 * 也适用与辅助构造器
 */
class Student2 private(var name:String,val age:Int){
  var gender:String=_
  private def this(name:String,age:Int,gender:String){
      this(name,age)
      this.gender=gender
  }
}
```

- 成员变量的访问权限

```scala
/*
 * private val age
 * age 在本类中有setter和getter方法
 * 但是加上private 也就意味着age只能在这个类的内部及其伴生类中可以修改
 */
class Student3 private(){
    private var name:String=_
    // 伴生类可以访问
    private var age:Int=_
    // private [this]关键字标识给属性只能在类内部访问，伴生类不能访问
    private [this] var gender:String="man"
}
// 伴生类
object Student3{
  def main(args: Array[String]): Unit = {
    val student = new Student3()
    // 伴生对象可以访问
    student.name="jack"
    student.age =20
    println(s"name=${student.name},age=${student.age}")
    // 伴生类不能访问
    //println(student.gender)
    // output:
    // name=jack,age=20
 
  }
}
```

- 类包的访问权限

```scala
/*
 * private [this] class放在类声明最前面，是修饰类的访问权限，也就是说类在某些包下可见或不能访问
 * private [sheep] class代表该类在sheep包及其子包下可见，同级包不能访问
 */
private [this] class Student4 (val name:String,private var age:Int){
      var gender :String=_
}
// 伴生类
object Student4{
  def main(args: Array[String]): Unit = {
    val s = new Student4("JackMa",18)
    print(s.age)
  }
}
```

### 5.2.3 伴生类 | apply 方法

在 Scala 中, 当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象。必须 在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类。类和它的伴生对象可以互相访问其私有成员。

```scala
/*
 * 定义一个apply方法
 * object对象中可以对apply进行各种重载
 */
object test{
  def main(args: Array[String]): Unit = {
    val v = test(2,3)// 语法糖
    print(v)
    //output:5
  }
  def apply(a:Int,b:Int)={
     a+b
  }
}
```

## 5.3 Trait

ScalaTrait(特质) 相当于 Java 的接口，实际上它比接口还功能强大。 与接口不同的是，它还可以定义属性和方法的实现。 一般情况下 Scala 的类只能够继承单一父类，但是如果是 Trait(特质) 的话就可以继承多个，实现了多重继承。使用的关键字是 trait。

```scala
trait ScalaTrail {
   // 定义了一个属性
  var pro:Int=666
 
  // 定义一个没有实现的方法
  def sayHello(name:String)
 
  // 定义了一个带具体实现的方法
  def small(name:String): Unit ={
    println(s"太阳对${name}笑")
  }
}
 
object ScalaTrailImpl extends ScalaTrail {
  // 实现方法时可以有override关键字，也可以没有
  def sayHello(name: String): Unit = {
    println(s"hello $name")
  }
  // 重写方法时必须得有override关键字
  override def small(name: String): Unit = {
    println(s"$name like small")
  }
}
 
object test extends App{
  ScalaTrailImpl.sayHello("Oliver")
  // 如果ScalaTrailImpl没有重写small方法，则调用ScalaTrail中已经实现了的方法
  // 如果ScalaTrailImpl重写了small方法，则调用的是ScalaTrailImpl中的方法
  ScalaTrailImpl.small("wang")
  // output:
  // hello Oliver
  // wang like small
}
```

动态混入特质，使用with关键字

```scala
trait ScalaTrail {
  // 定义了一个属性
  var pro:Int=666
  // 定义一个没有实现的方法
  def sayHello(name:String)
  // 定义了一个带具体实现的方法
  def small(name:String): Unit ={
    println(s"太阳对${name}笑")
  }
}
class Student {
 
}
 
object test extends App{
  val student: Student with ScalaTrail = new Student with ScalaTrail {
    override def sayHello(name: String): Unit = {
      println(f"name=$name")
    }
  }
  student.sayHello("Jack")
}
```

## 5.4 抽象类

在 Scala 中, 使用 abstract 修饰的类称为抽象类. 在抽象类中可以定义属性、未实现的方法和 具体实现的方法。

```scala
 
abstract class Animal{
  // 定义了一个属性
  var name:String="animal"
  // 定义一个未实现方法
  def sleep()
  // 定义一个带具体实现方法
  def eat(f:String): Unit ={
    println(s"eating $f")
  }
}
```

## 5.5 继承

继承是面向对象的概念，用于代码的可重用性。 被扩展的类称为超类或父类, 扩展的类称 为派生类或子类。Scala 可以通过使用 extends 关键字来实现继承其他类或者特质。

```scala
/*
 * with 后面只能是特质
 * 父类未实现的方法，子类必须实现
 * 父类已经实现的方法，子类要重写该方法，必须使用override关键字
 */
abstract class Animal{
  // 定义了一个属性
  var name:String="animal"
  // 定义一个未实现方法
  def sleep()
  // 定义一个带具体实现方法
  def eat(f:String): Unit ={
    println(s"eating $f")
  }
}
class Dog extends Animal {
  override def sleep(): Unit = {
    println("耳朵贴地睡")
  }
}
object test extends App{
  private val dog = new Dog
  dog.sleep();
  dog.eat("bone")
  // output:
  // 耳朵贴地睡
  // eating bone
}
```

### 5.5.1final 关键字

 

- 被 final 修饰的类不能被继承；
- 被 final 修饰的属性不能重写；
- 被 final 修饰的方法不能被重写。

### 5.5.2 type 关键字

Scala 里的类型，除了在定义 class,trait,object 时会产生类型，还可以通过 type 关键字来声明 类型。
type 相当于声明一个类型别名：

```scala
object test extends App{
   // 把String类型用S代替
  type S = String
  var name : S= "Oliver"
  println(name)
}
```

通常 type 用于声明某种复杂类型，或用于定义一个抽象类型。

```
class A{
  type T
  def fn(t:T): Unit ={
    println(t)
  }
}
class B extends A{
  override type T = Int
}
class C extends A{
  override type T = String
}
object test extends App{
  private val b = new B()
  private val c = new C()
  b.fn(3)
  c.fn("Hello")
}
```

## 5.6 样例类/样例对象

```scala
/*
 * 样例类，使用case关键字修饰的类，其重要的就是支持模式匹配
 * 样例类：case class 类名（属性）
 * 类名定义必须是驼峰式,属性名称第一个字母小写
 */
case class Message(sender:String,massageContent:String)
/*
 * 样例对象不能封装数据
 */
case object CheckHeartBeat
```

# 6. 模式匹配 match case

## 6.1 匹配字符串/类型/守卫

```scala
object test extends App{
  /*
   * 匹配字符串
   */
  def contentMatch(str:String)=str match {
      case "dog"=>println("小狗")
      case "cat"=>println("小猫")
      case "1"=>println("数字1")
      case _ => println("匹配失败")
  }
  contentMatch("cat")
  contentMatch("1")
  contentMatch("2")
  //  output:
  //  小猫
  //  数字1
  //  匹配失败
  /*
   * 匹配类型
   */
  def typeMatch(ele:Any)=ele match {
      case x:Int=>println(s"Int:${x}")
      case y:Double=>println(s"Double:${y}")
      case z:String=>println(s"String:${z}")
      case _ =>println("match failure")
  }
  typeMatch("helo")
  typeMatch(2)
  typeMatch(2d)
  //  output:
  //  String:helo
  //  Int:2
  //  Double:2.0
```

## 6.2 匹配数组

```scala
object test extends App{
  /*
   * 匹配数组
   */
  def arrayMatch(arr:Any)=arr match {
      case Array(0)=>println("只有一个0元素的数组")
      case Array(0,_)=>println("以0开头，拥有两个元素的数组")
      case Array(1,_,3)=>println("以1开头，3结尾的任意三个元素的数组")
      case Array(_*)=>println("N个元素的数组")
  }
  arrayMatch(Array(0))
  arrayMatch(Array(0,2))
  arrayMatch(Array(1,true,3))
  arrayMatch(Array(1,3,5,7,9))
  // output:
  // 只有一个0元素的数组
  // 以0开头，拥有两个元素的数组
  // 以1开头，3结尾的任意三个元素的数组
  // N个元素的数组
}
```

## 6.3 匹配集合

```scala
object test extends App{
  /*
   * 匹配集合
   */
  def listMatch(list:Any)=list match {
    case 0::Nil=>println("只有0元素的集合")
    case 7::9::Nil=>println("只有7和9两个元素的集合")
    case x::y::z::Nil=>println(s"只有三个元素集合${x},${y},${z}")
    case m::n=>println(s"拥有head和tail的集合。head:${m},tail:${n}")
  }
  listMatch(List(0))
  listMatch(List(7,9))
  listMatch(List(1,2,3))
  listMatch(List(8,7,6,5,4))
  // output:
  // 只有0元素的集合
  // 只有7和9两个元素的集合
  // 只有三个元素集合1,2,3
  // 拥有head和tail的集合。head:8,tail:List(7, 6, 5, 4)
}
```

## 6.4 匹配元组

```scala
object test extends App{
  /*
   * 匹配元组
   */
  def tupMatch(tup:Any)=tup match {
    case (3,x,y)=>println("第一个元素为3的元组")
    case (_,2)=>println("第二个元素为2，拥有两个元素的数组")
    case (x,y,z)=>println("拥有三个元素的任意元组")
  }
  tupMatch((3,2,1))
  tupMatch((3,2))
  tupMatch((4,2,1))
  //  output:
  //  第一个元素为3的元组
  //  第二个元素为2，拥有两个元素的数组
  //  拥有三个元素的任意元组
}
```

## 6.5 匹配样例类/样例对象

```scala
case object CheckTimeOutTask
case class SubmitTask(id:String,name:String)
case class HeartBeat(time:Long)
object test extends App{
  /*
   * 匹配样例类，样例对象
   */
  def coMatch(ele:Any)=ele match {
    case SubmitTask(id,name)=>println(s"submit task-id:${id},task-name:${name}")
    case CheckTimeOutTask=>println("checking.....")
    case HeartBeat(time)=>println(s"time is ${time}")
  }
  coMatch(SubmitTask("001","node1"))
  coMatch(CheckTimeOutTask)
  coMatch(HeartBeat(8888888L))
  coMatch(HeartBeat(6666))
  // output:
  // submit task-id:001,task-name:node1
  // checking.....
  // time is 8888888
  // time is 6666
}
```

# 7.Scala 高级语法

 

## 7.1 隐式（implicit）详解

- 隐式参数 
- 隐式转换类型
- 隐式类

### 7.1.1 隐式参数

定义方法时，可以把参数列表标记为 implicit，表示该参数是隐式参数。一个方法只会有一 个隐式参数列表，置于方法的最后一个参数列表。如果方法有多个隐式参数，只需一个 implicit 修饰即可。
譬如：deffire(x:Int)(implicita:String,b:Int=9527)
当调用包含隐式参数的方法是，如果当前上下文中有合适的隐式值，则编译器会自动为该 组参数填充合适的值，且上下文中只能有一个符合预期的隐式值。如果没有编译器会抛出 异常。当然，标记为隐式参数的我们也可以手动为该参数添加默认值。

```scala
object test extends App{
    def say(implicit content:String)=println(content)
    /*
     * say方法时隐式参数，如果你没有传参数
     * 编译器在编译的时候会自动的从当前上下文中找一个隐式值（符合参数类型的隐式值）
     */
    say("good morning")
    implicit val content="Are you ok ?"
    say
    //  output:
    //  good morning
    //  Are you ok ?
    
}
```

### 7.1.2 隐式的转换类型

使用隐式转换将变量转换成预期的类型是编译器最先使用 implicit 的地方。当编译器看到类 型 X 而却需要类型 Y，它就在当前作用域查找是否定义了从类型 X 到类型 Y 的隐式定义。

```scala
object test extends App{
 
  //var i:Int=3.14/*此时程序会报错*/
    implicit def double2Int( d:Double)=d.toInt
  // i是int类型，但是赋值的时候缺是一个浮点型，此时编译器会在当前上下文中找一个隐式转换，
  // 找一个double转换成int的隐式转换
    var i:Int=3.14
    println(i)
 
}
```

### 7.1.3 隐式类

在 Scala 中，我们可以在静态对象中使用隐式类。

```scala
 
object test extends App{
 
  implicit class Calculator(x:Int){
    def add(y:Int)={
      x+y
    }
  }
  var z:Int=5
  println(5.add(3))
}
```

## 7.2 泛型

通俗的讲，比如需要定义一个函数，函数的参数可以接受任意类型。我们不可能一一列举所 有的参数类型重载函数。

那么程序引入了一个称之为泛型的东西，这个类型可以代表任意的数据类型。

例如 List，在创建 List 时，可以传入整形、字符串、浮点数等等任意类型。那是因为 List 在 类定义时引用了泛型

```scala
/*
 *scala枚举类型
 */
object ClothesEnum extends Enumeration{
  type ClothesEnum=Value
  val 衣服,裤子,卫衣 =Value
}
/*
 * 定义了一个泛型类
 */
class Massage[T]{
  def getMassage(s:T): Unit ={
    println(s)
  }
}
/*
 * 子类继承指明类型
 */
class strMassage[String] extends Massage{
    
}
object test extends App{
  private val msg = new Massage[String]
  msg.getMassage("有内鬼，终止交易")
}
```

## 7.3 类型约束

### 7.3.1 上界(UpperBounds)/下界(lowerbounds)

- UpperBounds

在 Java 泛型里表示某个类型是 Test 类型的子类型，使用 extends 关键字：

```scala
<T extends Test>
 
//或用通配符的形式： 
<? extends Test>
```

这种形式也叫 upperbounds(上限或上界)，同样的意思在 Scala 的写法为：

```scala
[T <: Test]
 
//或用通配符: 
[_ <: Test]
```

- LowerBounds

在 Java 泛型里表示某个类型是 Test 类型的父类型，使用 super 关键字：

```scala
<T super Test>
 
//或用通配符的形式： 
<? super Test>
```

这种形式也叫 lowerbounds(下限或下界)，同样的意思在 scala 的写法为：

```scala
[T >: Test]
 
//或用通配符: 
[_ >: Test]
```

### 7.3.2 视图界定/上下文界定

- Viewbounds

<% 的意思是“viewbounds”(视界)，它比 <: 适用的范围更广，除了所有的子类型，还允许隐式转换过去的类型。

```scala
def method[A <% B](arglist):R=...
 
等价于:
def method[A](arglist)(implicit viewAB:A=>B):R=...
或等价于: 
implicit def conver(a:A):B= …
<% 除了方法使用之外，class 声明类型参数时也可使用： 
class A[T<%Int]
```

- Contextbounds

与 viewbounds 一样 contextbounds(上下文界定)也是隐式参数的语法糖。为语法上的方便， 引入了”上下文界定”这个概念。