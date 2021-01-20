# Scala 递归函数

递归函数在函数式编程的语言中起着重要的作用。

Scala 同样支持递归函数。

递归函数意味着函数可以调用它本身。

以上实例使用递归函数来计算阶乘：

```
object Test {
   def main(args: Array[String]) {
      for (i <- 1 to 10)
         println(i + " 的阶乘为: = " + factorial(i) )
   }
   
   def factorial(n: BigInt): BigInt = {  
      if (n <= 1)
         1  
      else    
      n * factorial(n - 1)
   }
}
```

执行以上代码，输出结果为：

```
$ scalac Test.scala
$ scala Test
1 的阶乘为: = 1
2 的阶乘为: = 2
3 的阶乘为: = 6
4 的阶乘为: = 24
5 的阶乘为: = 120
6 的阶乘为: = 720
7 的阶乘为: = 5040
8 的阶乘为: = 40320
9 的阶乘为: = 362880
10 的阶乘为: = 3628800
```