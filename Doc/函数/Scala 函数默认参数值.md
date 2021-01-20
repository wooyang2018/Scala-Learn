# Scala 函数 - 默认参数值

Scala 可以为函数参数指定默认参数值，使用了默认参数，你在调用函数的过程中可以不需要传递参数，这时函数就会调用它的默认参数值，如果传递了参数，则传递值会取代默认值。实例如下：

```
object Test {
   def main(args: Array[String]) {
        println( "返回值 : " + addInt() );
   }
   def addInt( a:Int=5, b:Int=7 ) : Int = {
      var sum:Int = 0
      sum = a + b

      return sum
   }
}
```

执行以上代码，输出结果为：

```
$ scalac Test.scala
$ scala Test
返回值 : 12
```