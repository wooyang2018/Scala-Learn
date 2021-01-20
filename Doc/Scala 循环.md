# Scala 循环

有的时候，我们可能需要多次执行同一块代码。一般情况下，语句是按顺序执行的：函数中的第一个语句先执行，接着是第二个语句，依此类推。

编程语言提供了更为复杂执行路径的多种控制结构。

循环语句允许我们多次执行一个语句或语句组，下面是大多数编程语言中循环语句的流程图：

![循环结构](https://lwy-picgo-img.oss-cn-beijing.aliyuncs.com/img20210119151748.png)

------

## 循环类型

Scala 语言提供了以下几种循环类型。点击链接查看每个类型的细节。

| 循环类型        | 描述                                                         |
| :-------------- | :----------------------------------------------------------- |
| while 循环      | 运行一系列语句，如果条件为true，会重复运行，直到条件变为false。 |
| do...while 循环 | 类似 while 语句区别在于判断循环条件之前，先执行一次循环的代码块。 |
| for 循环        | 用来重复执行一系列语句直到达成特定条件达成，一般通过在每次循环完成后增加计数器的值来实现。 |

------

## 循环控制语句

循环控制语句改变你代码的执行顺序，通过它你可以实现代码的跳转。Scala 以下几种循环控制语句：

Scala 不支持 break 或 continue 语句，但从 2.8 版本后提供了一种中断循环的方式，点击以下链接查看详情。

| 控制语句   | 描述     |
| :--------- | :------- |
| break 语句 | 中断循环 |

------

## 无限循环

如果条件永远为 true，则循环将变成无限循环。我们可以使用 while 语句来实现无限循环：

```scala
object Test {
   def main(args: Array[String]) {
      var a = 10;
      // 无限循环
      while( true ){
         println( "a 的值为 : " + a );
      }
   }
}
```

以上代码执行后循环会永久执行下去，你可以使用 Ctrl + C 键来中断无限循环。

## Scala while 循环

Scala 语言中 **while** 循环的语法：

```
while(condition)
{
   statement(s);
}
```

在这里，**statement(s)** 可以是一个单独的语句，也可以是几个语句组成的代码块。

**condition** 可以是任意的表达式，当为任意非零值时都为 true。当条件为 true 时执行循环。 当条件为 false 时，退出循环，程序流将继续执行紧接着循环的下一条语句。

```scala
object Test {
   def main(args: Array[String]) {
      // 局部变量
      var a = 10;

      // while 循环执行
      while( a < 20 ){
         println( "Value of a: " + a );
         a = a + 1;
      }
   }
}
```

## Scala do...while 循环

Scala 语言中 **while** 循环的语法：

```
do {
   statement(s);
} while( condition );
```

请注意，条件表达式出现在循环的尾部，所以循环中的 statement(s) 会在条件被测试之前至少执行一次。如果条件为 true，控制流会跳转回上面的 do，然后重新执行循环中的 statement(s)。这个过程会不断重复，直到给定条件变为 false 为止。

```scala
object Test {
   def main(args: Array[String]) {
      // 局部变量
      var a = 10;

      // do 循环
      do{
         println( "Value of a: " + a );
         a = a + 1;
      }while( a < 20 )
   }
}
```

## Scala for循环

Scala 语言中 **for** 循环的语法：

```
for( var x <- Range ){
   statement(s);
}
```

以上语法中，**Range** 可以是一个数字区间表示 **i to j** ，或者 **i until j**。左箭头 <- 用于为变量 x 赋值。

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      // for 循环
      for( a <- 1 to 10){
         println( "Value of a: " + a );
      }
   }
}
```

以下是一个使用了 **i until j** 语法(不包含 j)的实例:

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      // for 循环
      for( a <- 1 until 10){
         println( "Value of a: " + a );
      }
   }
}
```

在 **for 循环** 中你可以使用分号 (;) 来设置多个区间，它将迭代给定区间所有的可能值。以下实例演示了两个区间的循环实例：

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      var b = 0;
      // for 循环
      for( a <- 1 to 3; b <- 1 to 3){
         println( "Value of a: " + a );
         println( "Value of b: " + b );
      }
   }
}
```

## for 循环集合

for 循环集合的语法如下：

```
for( x <- List ){
   statement(s);
}
```

以上语法中， **List** 变量是一个集合，for 循环会迭代所有集合的元素。

以下实例将循环数字集合。我们使用 *List()* 来创建集合。再以后章节我们会详细介绍集合。

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6);

      // for 循环
      for( a <- numList ){
         println( "Value of a: " + a );
      }
   }
}
```

## for 循环过滤

Scala 可以使用一个或多个 **if** 语句来过滤一些元素。

以下是在 for 循环中使用过滤器的语法。

```
for( var x <- List
      if condition1; if condition2...
   ){
   statement(s);
```

你可以使用分号(;)来为表达式添加一个或多个的过滤条件。

以下是 for 循环中过滤的实例：

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6,7,8,9,10);

      // for 循环
      for( a <- numList
           if a != 3; if a < 8 ){
         println( "Value of a: " + a );
      }
   }
}
```

## for 使用 yield

你可以将 for 循环的返回值作为一个变量存储。语法格式如下：

```
var retVal = for{ var x <- List
     if condition1; if condition2...
}yield x
```

注意大括号中用于保存变量和条件，*retVal* 是变量， 循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。

以下实例演示了 for 循环中使用 yield：

```scala
object Test {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6,7,8,9,10);

      // for 循环
      var retVal = for{ a <- numList
                        if a != 3; if a < 8
                      }yield a

      // 输出返回值
      for( a <- retVal){
         println( "Value of a: " + a );
      }
   }
}
```

