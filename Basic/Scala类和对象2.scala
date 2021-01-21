//Scala重写一个非抽象方法，必须用override修饰符
class Person {
  var name = ""
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee extends Person {
  var salary = 0.0
  override def toString = super.toString + "[salary=" + salary + "]"
}

object Test extends App {
  //神奇发现竟然不写在main函数中的语句也能执行
  val fred = new Employee
  fred.name = "Fred"
  fred.salary = 50000
  println(fred)
}
