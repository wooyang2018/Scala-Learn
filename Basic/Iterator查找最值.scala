object Test {
  def main(args: Array[String]) {
    val ita = Iterator(20, 40, 2, 50, 69, 90)
    val itb = Iterator(20, 40, 2, 50, 69, 90)

    println("最大元素是：" + ita.max)
    println("最小元素是：" + itb.min)
    println("ita.size 的值: " + ita.size)
    println("itb.length 的值: " + itb.length)
  }
}
