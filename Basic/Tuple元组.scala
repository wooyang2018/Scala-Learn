//与列表一样，元组也是不可变的，但与列表不同的是元组可以包含不同类型的元素。
object Test {
  def main(args: Array[String]) {
    val t = (4, 3, 2, 1)
    val sum = t._1 + t._2 + t._3 + t._4
    println("元素之和为: " + sum)
    t.productIterator.foreach{ i =>println("Value = " + i )}
    println("字符串为: " + t.toString() )

    val t2 = new Tuple2("www.google.com", "www.runoob.com")
    println("交换后的元组: " + t2.swap )
  }
}
