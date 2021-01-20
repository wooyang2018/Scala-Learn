# Scala 函数 - 可变参数

Scala 允许你指明函数的最后一个参数可以是重复的，即我们不需要指定函数参数的个数，可以向函数传入可变长度参数列表。

Scala 通过在参数的类型之后放一个星号来设置可变参数(可重复的参数)。例如：

```
object Test {
   def main(args: Array[String]) {
        printStrings("Runoob", "Scala", "Python");
   }
   def printStrings( args:String* ) = {
      var i : Int = 0;
      for( arg <- args ){
         println("Arg value[" + i + "] = " + arg );
         i = i + 1;
      }
   }
}
```

执行以上代码，输出结果为：

```
$ scalac Test.scala
$ scala Test
Arg value[0] = Runoob
Arg value[1] = Scala
Arg value[2] = Python
```