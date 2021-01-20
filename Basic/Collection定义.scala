object Test {
  def main(args: Array[String]): Unit = {
    // 定义整型 List
    val x = List(1, 2, 3, 4)
    x.foreach{ println(_)}
    // 定义 Set
    val x2 = Set(1, 3, 5, 7)

    // 定义 Map
    val x3 = Map("one" -> 1, "two" -> 2, "three" -> 3)
    x3.keys.foreach { i =>
      print("Key = " + i)
      println(" Value = " + x3(i))
    }

    // 创建两个不同类型元素的元组
    val x4 = (10, "Runoob")

    // 定义 Option
    val x5: Option[Int] = Some(5)
  }
}
