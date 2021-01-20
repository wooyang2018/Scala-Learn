/*
Scala 有方法与函数，二者在语义上的区别很小。Scala 方法是类的一部分，
而函数是一个对象可以赋值给一个变量。换句话来说在类中定义的函数即是方法。
Scala 中的方法跟 Java 的类似，方法是组成类的一部分。
Scala 中的函数则是一个完整的对象，Scala 中的函数其实就是继承了 Trait 的类的对象。
Scala 中使用 val 语句可以定义函数，def 语句定义方法。
 */
object Test {
  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b

    return sum
  }
  //如果方法没有返回值，可以返回为 Unit，这个类似于 Java 的 void
  def printMe(): Unit = {
    println("Hello, Scala!")
  }
  def main(args: Array[String]) {
    println("Returned Value : " + addInt(5, 7));
  }
}
