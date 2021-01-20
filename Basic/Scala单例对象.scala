/*
在 Scala 中，是没有 static 这个东西的，但是它也为我们提供了单例模式的实现方法，那就是使用关键字 object。
Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数。
当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象：companion object。你必须在同一个源文件里定义类和它的伴生对象。
类被称为是这个单例对象的伴生类：companion class。类和它的伴生对象可以互相访问其私有成员。
 */
/*
 * private val age
 * age 在本类中有setter和getter方法
 * 但是加上private 也就意味着age只能在这个类的内部及其伴生类中可以修改
 */
class Student3 private(){
    private var name:String=_
    // 伴生类可以访问
    private var age:Int=_
    // private [this]关键字标识给属性只能在类内部访问，伴生类不能访问
    private [this] var gender:String="man"
}
// 伴生类
object Student3{
  def main(args: Array[String]): Unit = {
    val student = new Student3()
    // 伴生对象可以访问
    student.name="jack"
    student.age =20
    println(s"name=${student.name},age=${student.age}")
    // 伴生类不能访问
    //println(student.gender)
    // output:
    // name=jack,age=20
 
  }
}