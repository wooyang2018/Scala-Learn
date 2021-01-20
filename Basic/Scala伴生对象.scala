/*
在Scala中，类和对象可以共享同一个名称。
当一个对象与一个类共享一个名称时，它被称为伴生对象，并且该类被称为伴生类。
伴生对象是与另一个类或特征共享相同名称和源文件的对象。
一个trait可以看作是一个Java接口。
这种方法允许我们在类上创建静态成员。
伴生对象对实现辅助方法和工厂很有用。
要实现一个创建不同类型的形状的工厂，我们可以在Scala中创建一个形状工厂。
 */
trait Shape {
  def area: Double
}
object Shape {
  private class Circle(radius: Double) extends Shape {
    override val area = 3.14 * radius * radius
  }
  private class Rectangle(height: Double, length: Double) extends Shape {
    override val area = height * length
  }
  def apply(height: Double, length: Double): Shape =
    new Rectangle(height, length)
  def apply(radius: Double): Shape = new Circle(radius)

}

object Main extends App {
  val circle = Shape(2)
  println(circle.area)
  val rectangle = Shape(2, 3)
  println(rectangle.area)

}
