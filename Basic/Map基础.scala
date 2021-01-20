object Test {
  def main(args: Array[String]): Unit = {
    // 空哈希表，键为字符串，值为整型
    var A: Map[Char, Int] = Map()

    // Map 键值对演示
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")

    //如果需要添加 key-value 对，可以使用 + 号
    A += ('I' -> 1)
    A += ('J' -> 5)
    A += ('K' -> 10)
    A += ('L' -> 100)

    val nums: Map[Int, Int] = Map()

    /*
        keys     返回 Map 所有的键(key)
        values   返回 Map 所有的值(value)
        isEmpty  在 Map 为空时返回true
     */
    println("colors 中的键为 : " + colors.keys)
    println("colors 中的值为 : " + colors.values)
    println("检测 colors 是否为空 : " + colors.isEmpty)
    println("检测 nums 是否为空 : " + nums.isEmpty)

    /*
    你可以使用 ++ 运算符或 Map.++() 方法来连接两个 Map
     */
    val colors1 =
      Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 =
      Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
    //  ++ 作为运算符
    var colorsx = colors1 ++ colors2
    println("colors1 ++ colors2 : " + colorsx)
    //  ++ 作为方法
    colorsx = colors1.++(colors2)
    println("colors1.++(colors2) : " + colorsx)

    /*
    你可以使用 Map.contains 方法来查看 Map 中是否存在指定的 Key。
    */
    if(colors1.contains("red")){println("red键值对存在，对应的值为： "+colors1("red"))}
  }
}
