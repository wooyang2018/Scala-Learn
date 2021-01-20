# Scala 函数嵌套

我们可以在 Scala 函数内定义函数，定义在函数内的函数称之为局部函数。

以下实例我们实现阶乘运算，并使用内嵌函数：

```
object Test {
   def main(args: Array[String]) {
      println( factorial(0) )
      println( factorial(1) )
      println( factorial(2) )
      println( factorial(3) )
   }

   def factorial(i: Int): Int = {
      def fact(i: Int, accumulator: Int): Int = {
         if (i <= 1)
            accumulator
         else
            fact(i - 1, i * accumulator)
      }
      fact(i, 1)
   }
}
```

执行以上代码，输出结果为：

```
$ scalac Test.scala
$ scala Test
1
1
2
6
```