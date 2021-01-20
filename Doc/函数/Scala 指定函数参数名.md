# Scala 指定函数参数名

一般情况下函数调用参数，就按照函数定义时的参数顺序一个个传递。但是我们也可以通过指定函数参数名，并且不需要按照顺序向函数传递参数，实例如下：

```scala
object Test {
   def main(args: Array[String]) {
        printInt(b=5, a=7);
   }
   def printInt( a:Int, b:Int ) = {
      println("Value of a : " + a );
      println("Value of b : " + b );
   }
}
```

执行以上代码，输出结果为：

```shell
$ scalac Test.scala
$ scala Test
Value of a :  7
Value of b :  5
```

