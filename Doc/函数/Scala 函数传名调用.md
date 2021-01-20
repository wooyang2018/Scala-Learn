# Scala 函数传名调用(call-by-name)

Scala的解释器在解析函数参数(function arguments)时有两种方式：

- 传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部；
- 传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部

在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕，而传名调用是在函数内部进行参数表达式的值计算的。

这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。

```
object Test {
   def main(args: Array[String]) {
        delayed(time());
   }

   def time() = {
      println("获取时间，单位为纳秒")
      System.nanoTime
   }
   def delayed( t: => Long ) = {
      println("在 delayed 方法内")
      println("参数： " + t)
      t
   }
}
```

以上实例中我们声明了 delayed 方法， 该方法在变量名和变量类型使用 => 符号来设置传名调用。执行以上代码，输出结果如下：

```
$ scalac Test.scala 
$ scala Test
在 delayed 方法内
获取时间，单位为纳秒
参数： 241550840475831
获取时间，单位为纳秒
```

实例中 delay 方法打印了一条信息表示进入了该方法，接着 delay 方法打印接收到的值，最后再返回 t。