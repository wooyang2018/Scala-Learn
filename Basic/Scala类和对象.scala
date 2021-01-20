/*
类是对象的抽象，而对象是类的具体实例。类是抽象的，不占用内存，而对象是具体的，占用存储空间。类是用于创建对象的蓝图，
它是一个定义包括在特定类型的对象中的方法和变量的软件模板。
 */
//Scala中的类不声明为public，一个Scala源文件中可以有多个类。
class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("x 的坐标点: " + x);
    println("y 的坐标点: " + y);
  }
}
/*
Scala继承一个基类跟Java很相似, 但我们需要注意以下几点：
- 1、重写一个非抽象方法必须使用override修饰符。
- 2、只有主构造函数才可以往基类的构造函数里写参数。
- 3、在子类中重写超类的抽象方法时，你不需要使用override关键字。
 */
class Location(override val xc: Int, override val yc: Int, val zc: Int)
    extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println("x 的坐标点 : " + x);
    println("y 的坐标点 : " + y);
    println("z 的坐标点 : " + z);
  }
}
object Test {
  def main(args: Array[String]) {
    val pt = new Point(10, 20);
    // 移到一个新的位置
    pt.move(10, 10);

    val loc = new Location(10, 20, 15);
    // 移到一个新的位置
    loc.move(10, 10, 5);
  }
}
